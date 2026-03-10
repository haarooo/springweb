package example.day07.practice7.enroll;

import example.day07.practice7.course.CourseEntity;
import example.day07.practice7.course.CourseRepository;
import example.day07.practice7.student.StudentEntity;
import example.day07.practice7.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public boolean enrollPost(EnrollDto enrollDto , int sno , int cno){

            EnrollEntity enrollEntity = enrollDto.toEntity();
            Optional<StudentEntity> studentEntity = studentRepository.findById(sno);
            Optional<CourseEntity> courseEntity = courseRepository.findById(cno);
            enrollEntity.setStudentEntity(studentEntity.get());
            enrollEntity.setCourseEntity(courseEntity.get());
            EnrollDto saved = enrollRepository.save(enrollEntity).toDto();
            if(saved.getEno() >= 1){return true;}
            return false;
    }

    public boolean add3(Map<String , Object> map){

        EnrollEntity enrollEntity = new EnrollEntity();
        enrollEntity.setStatus(map.get("status").toString());

        int cno = (Integer) map.get("cno");
        Optional<CourseEntity> courseEntity = courseRepository.findById(cno);
        if(courseEntity.isPresent()){
            CourseEntity savedCourse = courseEntity.get();
            enrollEntity.setCourseEntity(savedCourse);
        }else{return false;}

        int sno = (Integer) map.get("sno");
        Optional<StudentEntity> studentEntity = studentRepository.findById(sno);
        if(studentEntity.isPresent()){
            StudentEntity savedStudent = studentEntity.get();
            enrollEntity.setStudentEntity(savedStudent);
        }else{return false;}

        EnrollEntity saved = enrollRepository.save(enrollEntity);
        if(saved.getEno() >= 1){return true;}
        return false;
    }



    public EnrollDto enrollFind(int eno){
        Optional<EnrollEntity> optional = enrollRepository.findById(eno);
        if(optional.isPresent()){return optional.get().toDto();}
        return null;
    }
}
