package pythonML.practice9.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import pythonML.practice9.dto.FashionDto;
import pythonML.practice9.entity.FashionEntity;
import pythonML.practice9.repository.FashionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FashionService {
    private final FashionRepository fashionRepository;


    public Object learn(){
        List<FashionDto> dtoList = fashionRepository.findAll().stream().map(FashionEntity::toDto).collect(Collectors.toList());
        WebClient webClient = WebClient.create();
        Object object = webClient
                .post()
                .uri("http://localhost:8000/api/model/train")
                .bodyValue(dtoList)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return ResponseEntity.ok(object);
    }


    public Object predict(FashionDto fashionDto){

        WebClient webClient = WebClient.create();
        Object object = webClient
                .post()
                .uri("http://localhost:8000/api/model/predict")
                .bodyValue(fashionDto)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return object;
    }

}
