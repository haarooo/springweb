package springweb.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import java.util.Map;

@Controller
public class ChatController {

    @MessageMapping("/chat") // 클라이언트가 서버에게 메시지를 보낸 주소 매핑
    @SendTo("/topic/message") // 서버가 연동(구독)된 클라이언트에게 전송
    public Map<String , Object> sendMessage(Map<String , Object> message){
        System.out.println("message = " + message);
        System.out.println("ChatController.sendMessage");
        return message;
    }
}
