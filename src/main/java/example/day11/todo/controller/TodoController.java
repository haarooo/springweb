package example.day11.todo.controller;

import example.day11.todo.dto.TodoDto;
import example.day11.todo.entity.TodoEntity;
import example.day11.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    //ResponseEntity : 응답객체 , 사용목적 : 응답값 외 추가적인 자료 포함<응답코드>
    // <> : 제네릭 , <?> 사용시 Object와 동일하게 모든 타입 대입 가능
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<TodoDto> result = todoService.findAll();
        return ResponseEntity.status(200).body(result); //HTTP 응답코드 200 또는 ok
    }

    // 2. 개별조회
    @GetMapping("/id")
    public ResponseEntity<?> findById(@RequestParam int id){
        TodoDto result = todoService.findById(id);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/title")
    public ResponseEntity<?> query1(@RequestParam String title){
        TodoDto result = todoService.query1(title);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/title/content")
    public ResponseEntity<?> query3(@RequestParam String title , @RequestParam String content){
        Map<String , Object> result = todoService.query3(title, content);
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/query4")
    public ResponseEntity<?> query4(@RequestParam String title){
        List<TodoDto> result = todoService.query4(title);
        return ResponseEntity.status(200).body(result);
    }

    // 6. 페이징처리
    @GetMapping("page")
    public ResponseEntity<?> page(@RequestParam int page , @RequestParam int size){
        return ResponseEntity.ok(todoService.page(page , size));
    }

    // 7. 페이징처리2
    @GetMapping("/page2")
    public ResponseEntity<?> page2(@RequestParam String keyword ,
                                   @RequestParam(defaultValue = "1") int page ,
                                   @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(todoService.page2(keyword , page , size));
    }
}

