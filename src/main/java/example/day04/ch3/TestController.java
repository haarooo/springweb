package example.day04.ch3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired TestService testService; // 의존성 주입

    @GetMapping("/test")
    public List<Member> getAllMembers(){
        List<Member> members = testService.getAllMembers();
        return members;

    }

    @PostMapping("/test2")
    public boolean saveMember(){
        boolean result = testService.saveMember();
        return result;
    }
}

