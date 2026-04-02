package example.practice.service;

import com.github.dockerjava.api.model.Task;
import example.practice.dto.TaskDto;
import example.practice.entity.TaskEntity;
import example.practice.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskDto taskPost(TaskDto taskDto){
        return taskRepository.save(taskDto.toEntity()).toDto();
    }

    public List<TaskDto> taskList(){
        return taskRepository.findAll().stream().map(TaskEntity::toDto).collect(Collectors.toList());
    }

    public TaskDto taskDetail(Long id){
        Optional<TaskEntity> optional = taskRepository.findById(id);
        if(optional.isPresent()){
            TaskDto taskDto = optional.get().toDto();
            return taskDto;
        }
        return null;
    }

    public TaskDto taskUpdate(TaskDto taskDto){
        Optional<TaskEntity> optional = taskRepository.findById(taskDto.getId());
        if(optional.isPresent()){
            TaskEntity taskEntity = optional.get();
            taskEntity.setTitle(taskDto.getTitle());
            taskEntity.setContent(taskDto.getContent());
            taskEntity.setStatus(taskEntity.getStatus());
            TaskDto updateDto = taskEntity.toDto();
            return updateDto;
        }
        return null;
    }

    public boolean taskDelete(Long id){
        Optional<TaskEntity> optional = taskRepository.findById(id);
        if(optional.isPresent()){
            taskRepository.deleteById(optional.get().getId());
            return true;
        }
        return false;
    }

}
