package example.day09.책예제;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ListViewResponse {
    private final int id;
    private final String title;
    private final String content;
    private LocalDateTime createdAt;

    public ListViewResponse(ArticleEntity articleEntity){
        this.id=articleEntity.getId();
        this.title=articleEntity.getTitle();
        this.content=articleEntity.getContent();
        this.createdAt=articleEntity.getCreatedAt();
    }
}
