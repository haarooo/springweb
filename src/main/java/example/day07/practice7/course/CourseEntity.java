package example.day07.practice7.course;

import example.day07.practice7.BaseTime;
import example.day07.practice7.enroll.EnrollEntity;
import example.day07.practice7.student.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
@Table(name = "course")
public class CourseEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cno;

    @Column(name = "courseName")
    private String courseName;

    @ToString.Exclude
    @OneToMany(mappedBy = "courseEntity")
    @Builder.Default
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

    public CourseDto toDto(){
        return CourseDto.builder()
                .cno(cno)
                .courseName(courseName)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
