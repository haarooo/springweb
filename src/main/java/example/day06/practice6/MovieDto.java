package example.day06.practice6;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {

    private Integer mno;
    private String title;
    private String director;
    private String releasedate;
    private String rating;
    private String createDate;
    private String updateDate;

    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .title(this.title)
                .director(this.director)
                .rating(this.rating)
                .releasedate(this.releasedate)
                .build();
    }

}
