package org.gorany;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;

@Controller
public class GreetingController {

	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @MessageMapping("/hello") //클라이언트에서 /hello라는 api로 메세제를 보내면 메소드 호출
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("message------------------------>" + message);
        
        //sessions.add(session);
        System.out.println(sessions);
        
        
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"); //sendTo에 메핑되어있는 api를 구독하고 있는 클라이언트들에게 브로드캐스팅
    }
    
    /*
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException {
    	System.out.println("handletextmessage~~~~~~~~~~~~~~~~~~~~~~~~~~!");
    	Map<String, String> value =  new Gson().fromJson(message.getPayload(), Map.class);
    	for(WebSocketSession webSocketSession : sessions) {
			webSocketSession.sendMessage(new TextMessage("gpio from Raspberry pi " + value.get("name")));
		}
		session.sendMessage(new TextMessage(value.get("name")));
		System.out.println("gpio from Raspberry pi : " + value.get("name"));
    }*/
    

}

