package example.day07.연관관계;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String bcontent;

    // 단방향 FK만들기
    @ManyToOne // 다수가 하나에게, 1:M , 여러개 게시물이 하나의 카텍소리를 참조
    @JoinColumn(name = "cno") // 관례적으로 fk필드명도 pk필드명과 동일
    private CategoryEntity categoryEntity;

    //양뱡향
    @OneToMany(mappedBy = "boardEntity")
    @ToString.Exclude@Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();
}
