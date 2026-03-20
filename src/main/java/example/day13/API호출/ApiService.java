package example.day13.API호출;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor



public class ApiService {

    //공공데이터 기준
    String serviceKey = "5029d3fcc5682ef4e8515b3d3ce16f20278ad581db341292b3bba24017fe6c5c";
    // web요청 객체 WebClient
    private final WebClient webClient = WebClient.builder().build();

    //1. 인천 / json타입
    public Map<String , Object> test1(){
        String uri = "https://api.odcloud.kr/api/15103411/v1/uddi:efd2cc22-353c-47f0-83e5-abc6dca54f6f";
        uri += "?serviceKey="+serviceKey;
        uri += "&page=1";
        uri += "&perPage=66";
        return webClient.get()
                .uri(uri) //요청할 api주소 넣어준다 url vs uri(매개변수 포함)
                .retrieve() // 반환/통신/응답 결과 수신
                .bodyToMono(Map.class) //반환값을 자바 타입으로 변경 , 즉 반환타입이 json이면 map으로 받는다
                .block(); // 동기()처리
    }

    // 2. 약국 xml 타입
    public Map<String , Object> test2(){
        String uri = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
        uri += "?pageNo=1";
        uri += "&numOfRows=10";
        String result = webClient.get()
                .uri(uri)
                //.header("Authorization" , "Infuser " + serviceKey)
                // HTTP 헤더란? HTTP 통신할때 부가정보포함하는 정보
                // 주로 인증 관련된 정보들을 포함하는 경우가있다 , API키 , 로그인상태
                .retrieve()
                .bodyToMono(String.class)
                .block();
        // String(xml) -> MAP/DTO 변환
        XmlMapper xmlMapper = new XmlMapper(); // xmlMapper 객체 생성

        // .readValue(변환할값 , 변환할타입.class) XML을 String으로 받은 것을 변환하기 위한 함수
        try {Map<String , Object> map = xmlMapper.readValue(result , Map.class); //String(XML) -> MAP 타입으로 변환
            return map;
        } catch (Exception e) {System.out.println(e);}


        return null;
    }





}






/*
    Api : 데이터 주고받고 기능을 공유할 수 있는 규칙/프로토콜 (HTTP)
    Rest API : HTTP 기반의 API

    종류
        1. 개발 : Spring Controller
        2. 활용 :
            2-1. 공공데이터
            2-2. LLM(AI) API ,
            2-3. 카카오(지도) , 네이버(로그인,데이터랩) , 구글(자동입력방지) , 번역 , 결제

    반환타입 : Json/XML
    스프링에서 외부 HTPP 요청 , 프로젝트1/서비스1 <--통신--> 프로젝트2/서비스2
        Spring Reactive Web
        - controller : 서버입장의 통신 받는곳
        - webflux : 서버입장에서 먼저 통신 요청

    XML이란? <>괄호를 사용한 마크업언어
        - 스프링(자바)에서 타입변환이 필요하다.


 */