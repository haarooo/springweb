package example.day03.practice03;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day03/attendance")
public class AttendanceController {

    @PostMapping
    public boolean post(@RequestBody AttendanceDto attendanceDto){
        System.out.println("AttendanceController.post");
        System.out.println("attendanceDto = " + attendanceDto);
        return true;
    }

    @GetMapping
    public List<AttendanceDto> get(){
        List<AttendanceDto> list = new ArrayList<>();
        AttendanceDto attendanceDto = AttendanceDto.builder().ano(1).studentName("강호동").status("결석").date("2026-02-27").build();
        list.add(attendanceDto);
        return list;
    }
    @GetMapping("/detail")
    public AttendanceDto get1(@RequestParam int ano){
        AttendanceDto attendanceDto = AttendanceDto.builder().ano(1).studentName("유재석").status("출석").date("2026-02-26").build();
        return attendanceDto;
    }
    @DeleteMapping
    public boolean delete(@RequestParam int ano){
        return true;
    }

    @PutMapping
    public boolean put(@RequestBody Map<String , Object> map){
        System.out.println("AttendanceController.put");
        System.out.println("map = " + map);
        return true;
    }
}
