package pythonML.practice6.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pythonML.practice6.dto.CarDto;
import pythonML.practice6.service.CarService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private  final CarService carService;

    @PostMapping("/study")
    public ResponseEntity<?> trans_data(){
        Object result = carService.getCar();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> requestPredict(@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.requestPredict(carDto));
    }


}
