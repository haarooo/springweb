package springweb.board.controller;

import example.AOP.JwtRequired;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.board.dto.BoardDto;
import springweb.board.service.BoardService;
import springweb.member.service.JWTService.JwtService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@CrossOrigin(value = "http://localhost:5173" , exposedHeaders = "Authorization" ,allowCredentials = "true")
public class BoardController {
    private final BoardService boardService;
    private final JwtService jwtService;

    // 회원제 글 등록
    @PostMapping("/write")
    public ResponseEntity<?> write(@RequestBody BoardDto boardDto , HttpSession session){
        // 1. 세션내 로그인 정보 확인
        Object object = session.getAttribute("loginMid");
        if(object == null){return ResponseEntity.ok(false);} //만약에 비로그인이면 글쓰기 실패
        // 2. 로그인 중이면
        String loginMid = (String)object;
        // 3. 서비스에게 입력받은 값과 세션에 저장된 값 전달
        boolean result = boardService.write(boardDto , loginMid);

        return ResponseEntity.ok(result);

    }

    @JwtRequired
    @PostMapping("/write2")
    public ResponseEntity<?> write2(@RequestBody BoardDto boardDto , HttpServletRequest request){
        String mid = (String) request.getAttribute("mid");
        return ResponseEntity.ok(boardService.write(boardDto , mid));
    }


    // 회원제 글등록 + 토큰 + 파일첨부
    @PostMapping("/write3")
    public ResponseEntity<?> write3(BoardDto boardDto , @RequestHeader("Authorization")String token){

        if(token == null || !token.startsWith("Bearer")){
            return ResponseEntity.ok(false);
        }
        token = token.replace("Bearer " , "");
        String mid = jwtService.getClaim(token);
        if(mid==null){return  ResponseEntity.ok(false);}
        return ResponseEntity.ok(boardService.write(boardDto , mid));
    }

    // 회원제 글등록 + 토큰 + 파일첨부 + 쿠키
    @PostMapping("/write4")
    public ResponseEntity<?> write4(BoardDto boardDto , @CookieValue(value = "token" ,required = false) String token){
        if(token == null){return ResponseEntity.ok(false);}
        String mid = jwtService.getClaim(token);
        if(mid==null){return  ResponseEntity.ok(false);}
        return ResponseEntity.ok(boardService.write(boardDto , mid));
    }

    // 전체조회
    @GetMapping("/findall")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<?> detail(@RequestParam Long bno){
        return ResponseEntity.ok(boardService.detail(bno));
    }


}
