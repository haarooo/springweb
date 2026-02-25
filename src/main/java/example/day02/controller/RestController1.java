package example.day02.controller;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//REST란? HTTP GET/POST/PUT/DELETE 활용하여 통신
//Controller란? view(사용자/클라이언트)와 model 사이의 통신 중계
//스프링이 해당 클래스를 이해할 수 있게 스프링 컨테이너에 빈(객체) 정보 등록
// HTTP 기능까지 포함된 어노테이션


@Controller
public class RestController1{
    //1. @Controller(+Component)이므로 싱글톤 생략
    //2. HTTP 기능(방법/함수/메소드)
    // Mapping : 클라이언트가 요청한 http 메소드와 매칭 어노테이션
    // 2-1 POST
    @PostMapping
    public void 등록하기(){System.out.println("RestController1.등록하기");}
    // 2-2 GET
    @GetMapping
    public void 조회하기(){System.out.println("RestController1.조회하기");}
    // 2-3 PUT
    @PutMapping
    public void 수정하기(){System.out.println("RestController1.수정하기");}
    // 2-4 DELETE
    @DeleteMapping
    public void 삭제하기(){System.out.println("RestController1.삭제하기");}

}


