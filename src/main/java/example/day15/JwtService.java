package example.day15;

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
@Transactional
@RequiredArgsConstructor
public class JwtService {

    // 임의의 값으로 토큰에 사용되는 암호화 계산식의 비밀번호
    private final String secretPwd = "12345678912345678912345678912345";
    // 내가 만든 임의의 앖 해시값으로 변환
    private final Key secretKey = Keys.hmacShaKeyFor(secretPwd.getBytes());

    // 1. JWT 토큰 생성 : 사용자의 정보를 json형식으로 암호화
    public String create(String data){
        String token = Jwts.builder() // 토큰 생성 시작
                .claim("data" , data) //토큰에 저장할 자료를 key와 value로 대입한다
                .setIssuedAt(new Date()) // 토큰 발급날짜/시간 , new Date() : 시스템 날짜/시간 반환 객체
                .setExpiration(new Date(System.currentTimeMillis()+1000*20))// 토큰 유지/유효 시간
                //.signWith(비밀키 , 암호화);
                .signWith(secretKey, SignatureAlgorithm.ES256) // 최종 토큰 암호화는 HS256 알고리즘 적용한다
                .compact(); // 토큰 최종 문자열로 반환
        return token;
    }

    // 2. JWT 토큰 값 추출
    public String read(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey) // 서명 검증에 필요한 비밀키 대입
                    .build()
                    .parseClaimsJws(token) // 검증할 토큰 대입한다
                    .getBody(); //검증 성공시 클레임(내용물=data) 가져온다
            return (String) claims.get("data"); // 저장된 값은 무조건 Object
        }catch (Exception e){System.out.println(e);}
        return null;
    }
}

/*
    JWT : json web token
        1. 정의 : json형식의 데이터를 사용하기 위한 토큰 기반의 인증 형식
        2. 목적 : 웹/앱에서 인증과 권한부여/확인(클라이언트) vs 세션(서버)

    사용법 :
        1) 설치
            implementation 'io.jsonwebtoken:jjwt-api:0.12.6'
            runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.6'
            runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.6'


*/
