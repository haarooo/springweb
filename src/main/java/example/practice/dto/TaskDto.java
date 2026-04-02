package example.practice.dto;

import example.practice.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {

    private Long id;
    private String title;
    private String content;
    private String requester;
    private String status;

    private String createdDate;
    private String updateDate;

    public TaskEntity toEntity(){
        return TaskEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .requester(requester)
                .status(status)
                .build();
    }
}
