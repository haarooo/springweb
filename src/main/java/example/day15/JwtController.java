package example.day15;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jwt")
public class JwtController {
    private final JwtService jwtService;

    // 1. JWT토큰생성 == 데이터를 암호화
    @GetMapping("/create")
    public ResponseEntity<?> create(@RequestParam String data){
        return ResponseEntity.ok(jwtService.create(data));
    }

    // 2. JWT토큰 값 추출 = 암호화된 JWT 토큰을 다시 평문으로
    @GetMapping("/read")
    public ResponseEntity<?> read(@RequestParam String token){
        return ResponseEntity.ok(jwtService.read(token));
    }
}
