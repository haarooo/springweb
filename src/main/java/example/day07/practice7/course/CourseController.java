package example.day07.practice7.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public boolean coursePost(@RequestBody CourseDto courseDto){

        boolean result = courseService.coursePost(courseDto);
        return result;
    }
}
