package springweb.member.service.JWTService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    //비밀키 정의
    private String secret = "123456789123456789123456789123456789"; // 개발자가 임의로 32글자 이상의 문자열 구성
    private Key secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    // 토큰 발급
        public String createToken(String mid){
        String token = Jwts.builder()
                .claim("mid" , mid) // key 와 value로 토큰에 저장할 값
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()*1000*60))
                .signWith(secretKey , SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
    // 토큰 클레임 추출
    public String getClaim(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody(); // 서명확인 토큰 클래임 반환
            Object obj = claims.get("mid");
            return (String)obj;
        }catch (Exception e){System.out.println(e);}
        return null; // 토큰이 없거나 유효하지 않을때
    }
}
