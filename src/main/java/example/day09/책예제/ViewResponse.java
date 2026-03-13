package example.day09.책예제;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ViewResponse {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ViewResponse(ArticleEntity articleEntity){
        this.id=articleEntity.getId();
        this.title=articleEntity.getTitle();
        this.content=articleEntity.getContent();
        this.createdAt=articleEntity.getCreatedAt();
    }
}
