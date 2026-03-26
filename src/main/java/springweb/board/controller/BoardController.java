package springweb.board.controller;

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

    @PostMapping("/write2")
    public ResponseEntity<?> write2(@RequestBody BoardDto boardDto , @RequestHeader("Authorization")String token){
        if(token == null || !token.startsWith("Bearer")){
            return ResponseEntity.ok(false);
        }
        token = token.replace("Bearer " , "");
        String mid = jwtService.getClaim(token);
        if(mid==null){return  ResponseEntity.ok(false);}
        return ResponseEntity.ok(boardService.write(boardDto , mid));
    }

    // 회원제 글등록 + 토큰 + 파일첨부
    @PostMapping("/wirte3")
    public ResponseEntity<?> write3(BoardDto boardDto , @RequestHeader("Authorization")String token){

        if(token == null || !token.startsWith("Bearer")){
            return ResponseEntity.ok(false);
        }
        token = token.replace("Bearer " , "");
        String mid = jwtService.getClaim(token);
        if(mid==null){return  ResponseEntity.ok(false);}
        return ResponseEntity.ok(boardService.write(boardDto , mid));
    }


}
