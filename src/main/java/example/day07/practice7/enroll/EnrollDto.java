package example.day07.practice7.enroll;

import example.day07.practice7.course.CourseDto;
import example.day07.practice7.course.CourseEntity;
import example.day07.practice7.student.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class EnrollDto {

    private Integer eno;
    private String status;
    private CourseDto courseDto;
    private StudentDto studentDto;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder()
                .eno(eno)
                .status(status)
                .courseEntity(courseDto.toEntity())
                .studentEntity(studentDto.toEntity())
                .build();

    }
}
