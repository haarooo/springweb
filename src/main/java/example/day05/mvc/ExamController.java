package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;


    // R : 조회
    @GetMapping("/day05/exam")
    public List<ExamDto> findAll(){
        List<ExamDto> result = examService.findAll();
        return result;
    }
    // C : 쓰기
    @PostMapping("/day05/exam")
    public boolean write(@RequestBody ExamDto examDto){
        boolean result = examService.write(examDto);
        return result;
    }

    // D : 삭제
    @DeleteMapping("/day05/exam")
    public boolean delete(@RequestParam int eno){
        boolean result = examService.delete(eno);
        return result;
    }

    // U : 수정
    @PutMapping("/day05/exam")
    public boolean update(@RequestBody ExamDto examDto){
        boolean result = examService.update(examDto);
        return result;
    }
}

