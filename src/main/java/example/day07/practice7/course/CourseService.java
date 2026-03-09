package example.day07.practice7.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public boolean coursePost(CourseDto courseDto){
        CourseEntity courseEntity = courseRepository.save(courseDto.toEntity());
        CourseDto save = courseEntity.toDto();
        if(save.getCno() >= 1 ){return true;}
        return false;
    }

}
