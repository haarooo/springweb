package example.practice.controller;

import example.practice.dto.TaskDto;
import example.practice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<?> taskPost(@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.taskPost(taskDto));
    }

    @GetMapping
    public ResponseEntity<?> taskList(){
        return ResponseEntity.ok(taskService.taskList());
    }

    @GetMapping("/detail")
    public ResponseEntity<?> taskDetail(@RequestParam Long id){
        return ResponseEntity.ok(taskService.taskDetail(id));
    }

    @PutMapping
    public ResponseEntity<?> taskUpdate(@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.taskUpdate(taskDto));
    }

    @DeleteMapping
    public ResponseEntity<?> taskDelete(@RequestParam Long id){
        return ResponseEntity.ok(taskService.taskDelete(id));
    }

}
