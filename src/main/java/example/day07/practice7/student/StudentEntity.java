package example.day07.practice7.student;


import example.day07.practice7.BaseTime;
import example.day07.practice7.course.CourseEntity;
import example.day07.practice7.enroll.EnrollEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sno;

    @Column(name = "studentName")
    private String studentName;

    @ToString.Exclude
    @OneToMany(mappedBy = "studentEntity")
    @Builder.Default
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

    public StudentDto toDto(){
        return StudentDto.builder()
                .sno(sno)
                .studentName(studentName)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }
}
