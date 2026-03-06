package example.종합.예제10.board.dto;

import example.종합.예제10.board.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.internal.ImmutableNamedBasicTypeImpl;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Integer cno;
    private String cwriter;
    private String comment;
    private String createDate;
    private String updateDate;
    private Integer bno;

    public CommentEntity toEntity(){
        return CommentEntity.builder()
                .cno(cno)
                .comment(comment)
                .cwriter(cwriter)
                .bno(bno)
                .build();
    }
}
