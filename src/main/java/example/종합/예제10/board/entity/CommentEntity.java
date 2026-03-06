package example.종합.예제10.board.entity;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.dto.CommentDto;
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
@Table(name = "comment")
public class CommentEntity extends BaseTime{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;
    
    @Column(name = "cwriter" , length = 255 , nullable = false)
    private String cwriter;
    
    @Column(name = "comment" , columnDefinition = "longtext not null")
    private String comment;

    @Column
    private Integer bno;

    public CommentDto toDto(){
        return CommentDto.builder()
                .cno(cno)
                .comment(comment)
                .cwriter(cwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .bno(bno)
                .build();

    }
}
