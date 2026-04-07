package springweb.member.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@CrossOrigin(value = "http://localhost:5173" , exposedHeaders = "Authorization")
public class MemberController {
    private final MemberService memberservice;

    // 1. 회원가입 post = create = save
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(memberservice.signUp(memberDto));
    }

    // 2. 로그인 post = select = find
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto , HttpSession session){
        // 1. 입력받은 아이디/ 비밀번호를 서비스에게 보낸다.
        boolean result = memberservice.login(loginDto);
        // 2. 만약에 로그인 성공이면 세션부여
            // 1) 매개변수에 HttpSession session
            // 2) 로그인 성공한 회원의 아이디를 세션객체내 저장
        session.setAttribute("loginMid" , loginDto.getMid()); // 속성명 , 속성값
        // 3. 아니면 실패
        return ResponseEntity.ok(result);
    }

    // 3. 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        // 1) 매배변수에 HttpSession session 받는다
        // 2) session.removeAttribute("삭제할 속성명");
        session.removeAttribute("loginMid");
        return ResponseEntity.ok(true);

    }

    // 4. 마이페이지 = Get = 현재 로그인 회원정보 = 세션 저장된 정보로 조회
    @GetMapping("/myinfo")
    public ResponseEntity<?> myInfo(HttpSession session){
        // 1) 로그인상태 꺼내기
        Object object = session.getAttribute("loginMid");
        // 2) 로그인 상태가 존재하지 않으면 비로그인 상태
        if(object ==null){return  ResponseEntity.ok(false);}
        // 3) 로그인 사애이면
        String loginMid = (String)object; // 강제 형변환 , 다운캐스팅(부모-->자식)
        // 4) 로그인된 mid로 서비스에게 전달하여 로그인된 mid의 dto 받아오기
        return ResponseEntity.ok(memberservice.myInfo(loginMid));
    }


}
