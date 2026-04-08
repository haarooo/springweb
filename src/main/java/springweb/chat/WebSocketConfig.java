package springweb.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//WebSocket 설치
@Configuration // 빈등록 (스프링 컨테이너)등록 , IOC
@EnableWebSocketMessageBroker // websocket + stomp 메시지 브로커 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    // 오버라이딩(재정의) vs 오버로딩(매개변수에 따라 메소드/생성자 정의)
    // super(상위객체) vs this(현재객체)
    //메세지 브로커 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 구독 주소 설정 : 클라이언트가 설정한 주로를 요청(구독)하면 서버에게 메시지를 받을 수 있다
        registry.enableSimpleBroker("/topic");

        // 5. 발행 주소 설정 : 클라이언트가 서버에게 메시지를 보낼 때 사영되는 주소 앞에 붙는 키워드
        registry.setApplicationDestinationPrefixes("/app");
    }

    // 메시지의 종착점
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //종착지가 HTTP가 아닌 ws(WebSocket)
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*"); // 요청 가능한 도메인들 , *: 모든 도메인 허용 , CORS;
    }



}

/*
    HTTP(프로토콜) : 클라이언트가 서버에게 요청하면 서버에게 응답받는 구조
        -> 단방향 구조 , 무상태(상태/값 유지 안함) , Request/Response
        -> RestApi CRUD
     vs
  WebSocket(프로토콜) : 클라이언트와 서버가 연결 상태 유지 , 서로 통신하는 구조
        -> 양방향 구조 , 상태유지 , STOMP(pub : 발행 / sub : 구독)
        -> 실시간 통신(채팅 , 알림 , 지도/실시간위치)
*/