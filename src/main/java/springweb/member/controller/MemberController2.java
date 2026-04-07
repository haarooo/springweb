package springweb.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JWTService.JwtService;
import springweb.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member2")
@CrossOrigin(value = "http://localhost:5173" , exposedHeaders = "Authorization")
public class MemberController2 {
    private final MemberService memberService;
    private final JwtService jwtService;



    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto ){
        boolean result = memberService.login(loginDto);
        // 1. 로그인 성공이면 토큰 부여
        if(result){
            String token = jwtService.createToken(loginDto.getMid()); //로그인 성공한 정보를 토큰에 저장
            return ResponseEntity.ok()
                    // 토큰은 주로 세션과 다르게 서버에 저장하지 않고 클라이언트에 저장한다
                    .header("Authorization" , "Bearer "+token) //HTTP 통신의 부가정보 단는 구역
                    //클라이언트에게 헤더에 발급받은 jwt토큰 반환 . Bearer token
                    .body(true);

        }
        return ResponseEntity.ok(false);
    }

    // 로그아웃



    // 마이페이지
    @GetMapping("/myinfo")  //HTTP 요청의 header 정보 매핑
    public ResponseEntity<?> myInfo(@RequestHeader ("Authorization") String token ){
        // HTTP 요청의 header 정보 매핑
        // @RequestHeader ("Authorization") String token 토큰을 매개변수로 받는다
        // 헤더가 없거나 토큰이 없으면 비로그인
        if(token == null || !token.startsWith("Bearer")){
            return ResponseEntity.ok(false);
        }
        // 토큰 추출 , 문자열.replace("기존문자" , "새로운문자") = 치환/교체
        token = token.replace("Bearer " , ""); //Bearer 없애기
        // 토큰에서 클레임(값) 추출
        String mid = jwtService.getClaim(token);
        if(mid==null){return ResponseEntity.ok(false);}
        // 토큰에서 꺼낸 값(mid)으로 회원정보 요청하기
        return ResponseEntity.ok(memberService.myInfo(mid));

    }



}
