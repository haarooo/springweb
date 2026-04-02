package example.practice.entity;

import example.practice.dto.TaskDto;
import example.practice.global.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "task")
public class TaskEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "content" , columnDefinition = "LONGTEXT" ,nullable = false)
    private String content;

    @Column(name = "requester" , nullable = false)
    private String requester;

    @Column(name = "status" , nullable = false)
    private String status;

    public TaskDto toDto(){
        return TaskDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .requester(requester)
                .status(status)
                .createdDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

}
