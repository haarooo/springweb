package example.day05;

import lombok.Builder;

public class 어노테이션 {
    /*
        스프링 주요 어노테이션
        세팅
        @SpringBootApllication : 스프링부트 환경 설정
        @ComponentScan : 동일/하위 패키지내 컴포넌트들을 스캔하여 빈 등록
        @Component : 빈 등록
        @Autowired : 빈 주입

        MVC패턴
        @Controller : HTTP 요청과 응답처리 +@Component 포함 , Spring MVC에서 통신 담당
        @Service : Spring MVC에서 비즈니스로직(DB처리 외 핵심코드) 담당
        @Repository : Spring MVC에서 퍼시스턴스(데이터베이스 데이터처리 코드) 담당

        Controller에서 주로 사용되는 어노테이션
        @RestController : +@ResponseBody + @Controller 포함
        @ResponseBody : HTTP Content-Type처리

        @RequestMapping : HTTP URL 매핑 , 주로 클래스 위에 작성시 공통URL정의
        @RequestParam : HTTP의 쿼리스트링(URL?매개변수=값) 매개변수 매핑
        @RequestBody : HTTP의 본문 매핑 , POST/PUT만 가능

        @GetMapping : HTTP 통신의 GET 방식의 요청 매핑
        @PostMapping : HTTP 통신의 POST 방식의 요청 매핑
        @PutMapping : HTTP 통신의 PUT 방식의 요청 매핑
        @DeleteMapping : HTTP 통신의 DELETE 방식의 요청 매핑

        롬복 주요 어노테이션
        @NoArgsConstructor : 인수 없는 생성자
        @AllArgsConstructor : 모든 인수있는 생성자
        @RequiredArgsConstructor : final 멤버변수 있는 생성자
        @Getter : 멤버변수들의 get메소드
        @Setter : 멤버변수들의 set메소드
        @ToString : 객체 주소값을 멤버변수값으로 반환 , 오버라이딩
        @Data : +@Getter + @Setter + ToString
        @Builder : 빌더패턴((new)생성자 대신에 메소드로 객체 생성방법)

    */


}
