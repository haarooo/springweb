package pythonML.practice6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import pythonML.practice6.dto.CarDto;
import pythonML.practice6.entity.CarEntity;
import pythonML.practice6.repository.CarRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Object getCar(){
        List<CarDto> dtoList = carRepository.findAll().stream().map(CarEntity::toDto).collect(Collectors.toList());
        WebClient webClient = WebClient.create();
        Object object = webClient
                .post()
                .uri("http://localhost:8000/api/receive")
                .bodyValue(dtoList)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return object;
    }

    public Object requestPredict(CarDto carDto){

        WebClient webClient = WebClient.create();
        Object object = webClient
                .post()
                .uri("http://localhost:8000/api/predict")
                .bodyValue(carDto)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
        return object;
    }


}
