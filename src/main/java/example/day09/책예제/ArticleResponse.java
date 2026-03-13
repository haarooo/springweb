package example.day09.책예제;

import lombok.Getter;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(ArticleEntity articleEntity){
        this.title=articleEntity.getTitle();
        this.content=articleEntity.getTitle();
    }
}
