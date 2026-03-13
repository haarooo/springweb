package example.day09.책예제;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigInteger;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;

@Data@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ArticleDto toDto(){
        return ArticleDto.builder()
                .id(id)
                .content(content)
                .title(title)
                .build();
    }

    public void update(String title , String content){
        this.title = title;
        this.content = content;
    }
}
