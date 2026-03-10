package example.day07.practice7.enroll;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class EnrollController {
    @Autowired
    private EnrollService enrollService;


    @PostMapping("/enroll")
    public boolean enrollPost(@RequestBody EnrollDto enrollDto , @RequestParam int sno , @RequestParam int cno){
        boolean result = enrollService.enrollPost(enrollDto , sno , cno);
        return result;
    }


    @GetMapping("/enroll")
    public EnrollDto enrollFind(@RequestParam int eno){
        EnrollDto enrollDto = enrollService.enrollFind(eno);
        return enrollDto;
    }

    @PostMapping("/enroll2")
    public boolean add3(@RequestBody Map<String , Object> map){
        boolean result = enrollService.add3(map);
        return result;
    }

}
