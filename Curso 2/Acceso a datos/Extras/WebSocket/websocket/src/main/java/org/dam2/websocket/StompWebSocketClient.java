package org.dam2.websocket;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class StompWebSocketClient {
	

	
	private static final String URL = "ws://localhost:8080/mywebsockets";
	
	public void run ()
	{

		 StompSessionHandler sessionHandler = new StompClientSessionHandler();
		 WebSocketClient client = new StandardWebSocketClient();
		 
	     WebSocketStompClient stompClient = new WebSocketStompClient(client);
	     
	     stompClient.setMessageConverter(new MappingJackson2MessageConverter());
	     
		 
		 

		 try {
			StompSession stompSession = stompClient.connect(URL, sessionHandler).get();
			stompSession.subscribe("/topic/messages", sessionHandler);
			
			
			Message message = new Message ("miguel","hola a los que están esuchando");
			stompSession.send("/app/mywebsockets",message);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 public static void main(String[] args) {
		 
		 StompWebSocketClient app = new StompWebSocketClient();
		 
		 app.run();
		 
		 new Scanner(System.in).nextLine();
	 }

}
