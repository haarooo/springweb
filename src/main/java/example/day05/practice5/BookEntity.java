package example.day05.practice5;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column(name = "bname" , length = 255 , nullable = true)
    private String bname;

    @Column(name = "bwriter" , length = 255 , nullable = true)
    private String bwriter;

    @Column(name = "publisher" , length = 255 , nullable = true)
    private String publisher;
}
