package example.day02.controller;

import org.apache.tomcat.util.net.IPv6Utils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Component // 빈 등록
//@Controller // + http 통신 기능 포함 = 사용처 : view 반환
@RestController // +ResponseBody 포함 = 사용처 : 값 반환
//@RequestMapping("/공통URL") 해당 컨트롤로내 메소드들이 사용하는 공통URL 정의한다.
@RequestMapping("/day02")
public class RestController3 {

    @GetMapping("/task6") // 클래스가 @RequestMapping("/공통URL")가지므로 localhost:8080/day02
    public String method1(){return "서버에게 받은 메세지";
    }

    @GetMapping("/task7")
    public int method2(@RequestParam String name , @RequestParam int age){
        System.out.println("RestController3.method2");
        System.out.println("name = " + name + ", age = " + age);
        return 7;
    }

    @GetMapping("/task8")
    public int method3(@RequestParam(required = false) String name , @RequestParam(name = "age") int 나이){
        //만약에 쿼리스트링의 매개변수명을 필수로 하지 않을경우는 @RequestParam(required = false)
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 0;
    }

    @DeleteMapping("/task9")
    public int method4(String name , @RequestParam(defaultValue = "19") int age){
        System.out.println("RestController3.method4");
        System.out.println("name = " + name + ", age = " + age);
        return 9;

    }

    //5.
    @DeleteMapping("/task10")
    public int method5(@RequestParam Map<String , Object> map){
        System.out.println("RestController3.method5");
        System.out.println("map = " + map);
        return 11;
    }

    //6
    @PostMapping("/task11")
    public int method5(@ModelAttribute ExamDto examDto){
        System.out.println("RestController3.mthod5");
        System.out.println("examDto = " + examDto);
        return 12;
    }
    //즉 URL?매개변수=값 방식인 쿼리스트링은 URL상 매개변수 노출이 된다.
    //Get/Delete -> 쿼리스트링 -> @ModelAttribute/@RequestParam
    //Post/Put -> +Body본문 -> @RequestBody
    //즉 URL상의 매개변수 노출을 가리기 위한 Body(본문)사용하자.
    // 개인정보/패스워드/민감한 정보들은 Post/Pust 사용 왜? Body사용 위헤

    //7
    //body : {"name" : "유재석" , "age" : 12}
    //HTML --> JS --> JAVA(controller->dao)
    @PostMapping("/task12")
    public int method6(@RequestBody ExamDto examDto){
        System.out.println("RestController3.method6");
        System.out.println("examDto = " + examDto);
        return 13;

    }
    //8
    @PutMapping("/task13")
    public int method7(@RequestBody Map<String , Object>map){
        System.out.println("RestController3.method7");
        System.out.println("map = " + map);
        return 14;
    }






}//class e
