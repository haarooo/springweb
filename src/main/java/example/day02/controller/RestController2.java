package example.day02.controller;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RestController2 {

    // java타입을 자동으로 HTTP contents Type 반환해준다 int-> application/json
    @GetMapping("/day02/task")
    @ResponseBody
    public int method1(){
        System.out.println("RestController1.method1");return 100;
    }

    //2. 문자열 반환하는 메소드
    @GetMapping("/day02/task2")
    @ResponseBody
    public String method2(){
        System.out.println("RestController1.method2");return "유재석";
    }
    //3. map타입반환하는 메소드
    @GetMapping("/day02/task3")
    @ResponseBody
    public Map<String , Object> method3(){
        Map<String , Object> map = new HashMap<>();
        map.put("유재석" , 100); map.put("강호동", 50);
        return map;
    }

    //4. boolean 타입 반환
    @GetMapping("/day02/task4")
    @ResponseBody
    public boolean method4(){return true;}

    //5. dto 타입 반환
    @GetMapping("/day02/task5")
    @ResponseBody
    public TaskDto method5() {
        TaskDto taskDto = new TaskDto();
        taskDto.name = "유재석"; taskDto.point = 100;
        return taskDto;
    }

    //즉 String 제외한 자바의 대두분 타입은 application/json 으로  http content-type으로 설정



}//calss e
class TaskDto{String name ; int point;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPoint() {return point;}
    public void setPoint(int point) {this.point = point;}
}
