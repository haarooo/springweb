package example.day07.practice7.enroll;

import example.day07.practice7.course.CourseEntity;
import example.day07.practice7.student.StudentEntity;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollService {
    @Autowired
    private EnrollRepository enrollRepository;

    public boolean enrollPost(EnrollDto enrollDto , int sno , int eno){
            EnrollEntity enrollEntity = new EnrollEntity();
            StudentEntity studentEntity = enrollRepository.findById(sno).get().getStudentEntity();
            CourseEntity  courseEntity = enrollRepository.findById(eno).get().getCourseEntity();
            EnrollEntity saved = enrollRepository.save(enrollDto.toEntity());
            enrollEntity.setCourseEntity(courseEntity);
            enrollEntity.setStudentEntity(studentEntity);
            EnrollDto enrollDto1 = saved.toDto();
            if(enrollDto1.getEno() >= 1){return true;}
            return false;
    }

    public EnrollDto enrollFind(int eno){
        Optional<EnrollEntity> optional = enrollRepository.findById(eno);
        if(optional.isPresent()){return optional.get().toDto();}
        return null;
    }
}
