package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;
    private String cname;

    // 양방향 데이터베이스 존재하지 않는다
    @OneToMany(mappedBy = "categoryEntity") // 하나가 다수에게 , 1 : M , 자바에서만 사용
    @ToString.Exclude
    @Builder.Default
    private List<BoardEntity> boardEntityList = new ArrayList<>();

}
