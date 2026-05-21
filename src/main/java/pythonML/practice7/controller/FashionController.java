package pythonML.practice7.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pythonML.practice6.dto.CarDto;
import pythonML.practice7.dto.FashionDto;
import pythonML.practice7.repository.FashionRepository;
import pythonML.practice7.service.FashionService;

@RestController
@RequestMapping("/api/fashion")
@RequiredArgsConstructor
public class FashionController {
    private final FashionService fashionService;

    @PostMapping("/learn")
    public ResponseEntity<?> learn(){
        Object result = fashionService.learn();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/predict")
    public ResponseEntity<?> predict(@RequestBody FashionDto fashionDto){
        return ResponseEntity.ok(fashionService.predict(fashionDto));
    }

}
