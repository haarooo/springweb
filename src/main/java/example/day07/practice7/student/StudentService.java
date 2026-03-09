package example.day07.practice7.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public boolean studentPost(StudentDto studentDto){
        StudentEntity studentEntity = studentRepository.save(studentDto.toEntity());
        StudentDto save = studentEntity.toDto();
        if(save.getSno() >= 1 ){return true;}
        return false;
    }

}
