package example.day07.practice7.course;

import example.day07.practice7.enroll.EnrollDto;
import example.day07.practice7.enroll.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class CourseDto {
    private Integer cno;
    private String courseName;

    private String createDate;
    private String updateDate;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .cno(cno)
                .courseName(courseName)
                .build();
    }
}
