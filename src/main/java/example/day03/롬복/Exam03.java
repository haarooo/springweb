package example.day03.롬복;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

public class Exam03 {
    public static void main(String[] args) {
        /*
            롬복 lombok : 반복되는 코드들을 줄여주는 라이브러리
            1. 인텔리제이 설치
                [파일] -> [설정] -> [플러그인] -> 'lombok'
            2. 프로젝트 의존성 추가
                1. https://start.spring.io
                2. Dependencies 에서 lombok 검색 후 추가
                3. [Explore] -> 롬복관련 디펜더시 코드만 복사
                    compileOnly 'org.projectlombok:lombok'
                    annotationProcessor 'org.projectlombok:lombok'
                4. 프로젝트내 build.gradle 파일에 dependencies{}안에 붙여넣기
                5. build.gradle 새로고침
        */

        StudentDto studentDto = new StudentDto();
        StudentDto studentDto1 = new StudentDto(1, "유재석");
        studentDto1.getSname();
        studentDto1.setSname("강호동");
        studentDto1.toString();

        // 생성자는 매개변수의 순서대로 인자값 전달해야한다. 유연성 떨어진다
        // StudentDto studentDto2 = new StudentDto("유재석" , 1);
        // 해결책 : 빌더패턴(객체를 만드는 패턴 = 유연성 제공)
        // 클래스명.builder().멤버변수명(값).build();
        StudentDto studentDto2 = StudentDto.builder().sno(1).sname("유재석").build();
        StudentDto studentDto3 = StudentDto.builder().sname("강호동").build();

    }//main e
}//class e

@NoArgsConstructor // 컴파일(코드가 번역)될때 기본생성자 코드 자동 생성
@AllArgsConstructor // 컴파일(코드가 번역)될때 풀생성자 코드 자동 생성
//@RequiredArgsConstructor // final 매개변수 생성자 자동 생성
@Getter // 게터 메소드 생성
@Setter // 세터 메소드 생성
@ToString // 투스트링 메소드 생성
// @Data = @Getter , @Setter , @ToString
@Builder
class StudentDto{
    //1. private 멤버변수
    private int sno;
    private String sname;
    //2. 빈생성자 , 풀생성자



    //3. 게터,세터 , toString
}
