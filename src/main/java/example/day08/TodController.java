package example.day08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodController {

    @Autowired
     private TodoRepository todoRepository;
    @PostMapping("/")
    public boolean post(@RequestBody TodoEntity todoEntity){
        todoRepository.save(todoEntity);
        return true;
    }
    @GetMapping("/")
    public List findAll(){
        return todoRepository.findAll();

    }
}
