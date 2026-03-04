package example.day05.mvc;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.springframework.stereotype.Component;

@Entity //해당 객체는 데이터베이스 연동 하겠다는 뜻
@Table (name = "exam") //데이터베이스에서 테이블명 정의
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamEntity { // 데이터 실제의 본체/값 , 데이터베이스와 연동된 객체, 주의할점 : 이동 목적으로 사용되면 노출 가능

    @Id //primary key 적용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 적용
    private Integer eno;

    @Column(name = "ename" , length = 255 , nullable = true) //테이블 필드
    private String ename;
}
