package example.day07.practice7.student;

import example.day07.practice7.enroll.EnrollDto;
import example.day07.practice7.enroll.EnrollEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class StudentDto {
    private Integer sno;
    private String studentName;
    private String createDate;
    private String updateDate;

    public StudentEntity toEntity(){
        return StudentEntity.builder()
                .sno(sno)
                .studentName(studentName)
                .build();
    }
}
