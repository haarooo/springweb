package example.day06.practice6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.beans.BulkBean;
import org.springframework.stereotype.Component;
import tools.jackson.core.ObjectReadContext;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movie")
public class MovieEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mno;

    @Column(name = "title" , length = 30 , nullable = false)
    private String title;

    @Column(name = "director" , length = 10 , nullable = false)
    private String director;

    @Column(name = "releasedate" , length = 30 , nullable = false)
    private String releasedate;

    @Column(name = "rating" , length = 10 , nullable = false)
    private String rating;

    public MovieDto toDto(){
        return MovieDto.builder()
                .mno(this.mno)
                .title(this.title)
                .director(this.director)
                .rating(this.rating)
                .releasedate(this.releasedate)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

}
