package test.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.department.dto.DepartmentDto;
import test.department.service.DepartmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
@CrossOrigin(value = "http://localhost:5173")
public class DepartmentController {
    private final DepartmentService departmentService;


    // 부서 등록
    @PostMapping
    public ResponseEntity<?> departPost(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.departPost(departmentDto));
    }
    // 전체 부서 조회
    @GetMapping
    public ResponseEntity<?> departGet(){
       List<DepartmentDto> dtoList = departmentService.departGet();
       return ResponseEntity.ok(dtoList);
    }
    // 부서명 수정
    @PutMapping
    public ResponseEntity<?> departUpdate(@RequestBody DepartmentDto departmentDto){
        DepartmentDto result = departmentService.departUpdate(departmentDto);
        if(result == null){
            return ResponseEntity.status(500).body("수정실패");
        }return ResponseEntity.ok(result);
    }

    // 부서 삭제
    @DeleteMapping
    public ResponseEntity<?> departDelete(@RequestParam Long departmentId){
        boolean result = departmentService.departDelete(departmentId);
        if(result==false){
            return ResponseEntity.status(500).body("삭제실패");
        }return ResponseEntity.ok(result);
    }

}
