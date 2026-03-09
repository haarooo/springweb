package example.day07.practice7.enroll;

import example.day07.practice7.BaseTime;
import example.day07.practice7.course.CourseEntity;
import example.day07.practice7.student.StudentEntity;
import example.day07.연관관계.BoardEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "enroll")
public class EnrollEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eno;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER )
    @JoinColumn(name = "cno")
    private CourseEntity courseEntity;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER )
    @JoinColumn(name = "sno")
    private StudentEntity studentEntity;


    public EnrollDto toDto(){
        return EnrollDto.builder()
                .eno(eno)
                .status(status)
                .courseDto(courseEntity.toDto())
                .studentDto(studentEntity.toDto())
                .build();
    }
}
