package example.day07.practice7.enroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollController {
    @Autowired
    private EnrollService enrollService;

    @PostMapping("/enroll")
    public boolean enrollPost(@RequestParam EnrollDto enrollDto , int sno , int cno){
        boolean result = enrollService.enrollPost(enrollDto , sno , cno);
        return result;
    }
    @GetMapping("/enroll")
    public EnrollDto enrollFind(@RequestParam int eno){
        EnrollDto enrollDto = enrollService.enrollFind(eno);
        return enrollDto;
    }

}
