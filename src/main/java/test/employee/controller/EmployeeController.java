package test.employee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.employee.dto.EmployeeDto;
import test.employee.service.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@CrossOrigin(value = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;

    //사원 등록
    @PostMapping
    public ResponseEntity<?> employeePost(EmployeeDto employeeDto){
        EmployeeDto result = employeeService.employeePost(employeeDto);
        if(result == null){
            return ResponseEntity.status(500).body("사원 등록 실패");
        }return ResponseEntity.ok(result);
    }

    //사원 전체 조회
    @GetMapping
    public ResponseEntity<?> employeeGet(){
        return ResponseEntity.ok(employeeService.employeeGet());
    }

    //사원 수정
    @PutMapping
    public ResponseEntity<?> employeeUpdate(EmployeeDto employeeDto){
        EmployeeDto result = employeeService.employeeUpdate(employeeDto);
        if(result == null){
            return ResponseEntity.status(500).body("수정실패");
        }return ResponseEntity.ok(result);
    }

    //사원 삭제
    @DeleteMapping
    public ResponseEntity<?> employeeDelete(@RequestParam Long employeeId){
        boolean result = employeeService.employeeDelete(employeeId);
        if(result == false){
            return ResponseEntity.status(500).body("삭제 실패");
        }return ResponseEntity.ok(result);
    }



}
