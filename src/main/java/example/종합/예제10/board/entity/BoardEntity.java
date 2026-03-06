package example.종합.예제10.board.entity;

import example.종합.예제10.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "board")
public class BoardEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    @Column(name = "btitle", nullable = false , length = 255)
    private String btitle;
    @Column(name = "bcontent" , columnDefinition = "longtext not null")
    private String bcontent;
    @Column(name = "bwriter" , nullable = false , length = 255)
    private String bwriter;

    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(bno)
                .btitle(btitle)
                .bwriter(bwriter)
                .bcontent(bcontent)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();

    }
}
