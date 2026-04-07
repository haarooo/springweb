package springweb.member.controller;

import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JWTService.JwtService;
import springweb.member.service.MemberService;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member3")
@CrossOrigin(value = "http://localhost:5173" , allowCredentials = "true")
public class MemberController3 {
    private final MemberService memberService;
    private final JwtService jwtService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto , HttpServletResponse response){
        boolean result = memberService.login(loginDto);
        // 1. 로그인 성공이면 토큰 부여
        if(result){
            String token = jwtService.createToken(loginDto.getMid()); //로그인 성공한 정보를 토큰에 저장
            Cookie cookie = new Cookie("token" , token);
            // 쿠키 옵션
            cookie.setHttpOnly(true) ; // .setHttpOnly(true) : 쿠키 접근 방법 , true이면 js가 접근 못한다
            cookie.setSecure(false); // .setSecure(true) : true이면 https만 접근 가능
            cookie.setPath("/"); // .setPath(); 쿠키 접근하는 경로 , "/" : 전체경로
            // cookie.setMaxAge(); 쿠키 유지 시간
            response.addCookie(cookie);

        return ResponseEntity.ok(true);
        }else{ return ResponseEntity.ok( false ); }
    }

    // 마이페이지
    @GetMapping("/myinfo")  //HTTP 요청의 header 정보 매핑
    public ResponseEntity<?> myInfo(@CookieValue(value = "token" , required = false) String token ){
        // @CookieValue : HTTP 요청의 cookie 정보 매핑
        // @CookieValue("token") String token 매개변수로 받는다 , required=false 설정하면 필수값이 아닌 상태
        // 만약에 쿠키 값이 없으면 비로그인
        if(token == null){return ResponseEntity.ok(false);}
        // 토큰에서 클레임(값) 추출
        String mid = jwtService.getClaim(token);
        if(mid==null){return ResponseEntity.ok(false);}
        // 토큰에서 꺼낸 값(mid)으로 회원정보 요청하기
        return ResponseEntity.ok(memberService.myInfo(mid));

    }

    // 3. 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        // 1) 매배변수에 HttpServletResponse reponse
        // 2) 동일한 속성명으로 null값 저장하는 쿠키 생성
        Cookie cookie = new Cookie("token" , null);
        cookie.setMaxAge(0); //쿠키 생명주기를 0으로 설정
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok(true);
    }


}

/*

    HTTP : 문자 이동 규칙/규약
    톰캣 세션
        : 서버  , 보안 높음 , 로그인
      vs
    쿠키 : 브라우저 보안 낮음(JWT) , 로그인/장바구니

        *TOKEN : 특정한 자료 암호화(JWT)해서 인증

   1. 세션은 서버에 저장하므로 보안이 높지만 대규모 서버에는 과부하 증가한다.
   2. 토큰은 세션/쿠키 없이 HTTP를 사용하지 않으므로 웹/앱 통합 가능
   3. 쿠키는 브라우저에 저장하므로 보안이 낮지만 JWT와 같이 사용하며 서버에 과부하 낮출 수 있다
*/
