package example.day07.practice7.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public boolean studentPost(@RequestBody StudentDto studentDto){

        boolean result = studentService.studentPost(studentDto);
        return result;
    }
}
