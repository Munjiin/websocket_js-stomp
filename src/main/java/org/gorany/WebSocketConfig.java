package org.gorany;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{


	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic"); //메세지 브로커가 해당 api를 구독하고 있는 클라이언트들에게 메세지를 전달
		config.setApplicationDestinationPrefixes("/app"); //서버에서 클라이언트로부터 메세지를 받을 api의  prefix를 설정
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) { //클라이언트에서  websocket을 연결할  api 설정
		registry.addEndpoint("/gs").setAllowedOrigins("*").withSockJS(); //end point 설정
	}
	
	
	
	
	
}
