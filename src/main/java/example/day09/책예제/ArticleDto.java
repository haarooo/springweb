package example.day09.책예제;

import lombok.*;

import java.math.BigInteger;

@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class ArticleDto {
    private Integer id;
    private String content;
    private String title;

    public ArticleEntity toEntity(){
        return ArticleEntity.builder()
                .id(id)
                .content(content)
                .title(title)
                .build();
    }


}
