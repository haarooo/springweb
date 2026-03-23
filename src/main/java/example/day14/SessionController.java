package example.day14;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("session")
public class SessionController {

    // 1. 세션객체 내 값 저장
    @PostMapping
    public ResponseEntity<?> test1(@RequestParam String data , HttpServletRequest request){
        // 1. HTTPServletRequest request : HTTP 요청 정보를 담고 있는 객체
        System.out.println(request.getRemoteAddr()); // 요청한 클라이언으(사용자)IP  주소 얻기(로그/추적)
        System.out.println(request.getHeader("User-Agent")); // 요청한 클라이언트 브라우저 정보
        System.out.println(request.getSession()); //요청한 클라이언트의 세션갹체 정보 , 각 브라우저 마다 할당

        // 2. 세션객체
        HttpSession session = request.getSession();
        System.out.println(session.getId()); // 세션의 식별번호 반환 , 브라우저/디바이스 마다 할당
        System.out.println(session.getCreationTime()); // 세션의 최초 생성 시간
        System.out.println(session.getLastAccessedTime()); // 세션의 마지막 접근 시간
        System.out.println(session.getMaxInactiveInterval()); // 세션의 최대 유효시간(밀리초)

        // 3. 세션객체 내 값 저장 == 로그인
        session.setAttribute("data" , data); // 세션객체내 값(key:value) 저장
        System.out.println(session.getAttribute("data")); //세션객체내 값(key) 호출

        return ResponseEntity.ok(true);
    }


    // 2. 세션객체 내 값 호출
    @GetMapping
    public ResponseEntity<?> test2(HttpServletRequest request){
        System.out.println(request.getHeader("User-Agent"));
        // 1. 세션객체 반환
        HttpSession session = request.getSession();
        // 2. 세션객체내 특정한 속성 반환 , 모든 값은 Object로 반환
        Object obj = session.getAttribute("data"); //data라는 이름의 속성값 반환
        // 3. 유효성검사 , 있으면 로그인중 , 없으면 비로그인
        if(obj==null){
            System.out.println("상태없음");
            return ResponseEntity.ok(false); // 서버 재실행하면 초기화
        }else{
            String data = (String)obj;
            System.out.println("상태있음"+data);
            return ResponseEntity.ok(true);
        }

    }
    // 3. 세션객체 내 속성 제거
    @DeleteMapping
    public ResponseEntity<?> test3(HttpSession session){
        // 1. 속성 전체 초기화
        //session.invalidate(); //세션객체내 모든속성 제거
        // 2. 특정 속성 초기화
        session.removeAttribute("data");
        return ResponseEntity.ok(true);
    }










}// e


/*
    톰캣 세션
        1. 정의 : 톰캣(서버프로그램)내 데이터를 저장하고 관리할 수 있게 메모리(객체) 제공
        2. 목적 : 1) 상태/값 관리 2) 인증/권한 3) 효율적인 메모리 관리
        3. 사용처
            1) 로그인상태 2) 비회원제 장바구니 3) 실시간처리
        4. 특징 : 브라우저(크롬/엣지/사파리/TV) 마다 별도의 세션 객체 할당

        HTTPServletRequest
            - 서블릿(Servlet) : WAS(톰캣) 서버내 웹기술이 가능하게 자바의 HTTP통신 클래스 객체
            - 주요메소드
                1) .getRemoteAddr(); 요청한 클라이언트의 IP반환
                2) .getHeader("User-Agent"); 요청한 클라이언트의 브라우저 정보 반환(디바이스 뭘로 들어왔는지 등)
                3) .getSession 요청한 클라이언트의 세션객체 반환 브라우저 마다


        HTTPSession
            1. 세션 : 메모리가 저장되는 구역
            2. 톰캣 세션 : HTTP 객체내 제공 받는 메모리 구역
            3. 주요 메소드
                1) .setAttribute("속성명",값) : 세션객체내 속성명과 속성값 저장 , 주로 로그인 상태/정보
                2) .getAttribute("속성명") : 세션객체내 속성명 이용한 속서앖 호출
 */

