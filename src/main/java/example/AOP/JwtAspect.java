package example.AOP;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springweb.member.service.JWTService.JwtService;

public class JwtAspect {

    private final JwtService jwtService;

    public JwtAspect(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Before("@annotation(example.JwtRequired)")
    public void checkJwt(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("토큰이 없습니다.");
        }

        token = token.replace("Bearer ", "");
        String mid = jwtService.getClaim(token);

        if (mid == null) {
            throw new RuntimeException("유효하지 않은 토큰입니다.");
        }

        request.setAttribute("mid", mid);
    }
}
