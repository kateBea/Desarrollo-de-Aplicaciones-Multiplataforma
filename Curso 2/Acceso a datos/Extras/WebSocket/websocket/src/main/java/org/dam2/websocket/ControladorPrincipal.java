package org.dam2.websocket;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class ControladorPrincipal {
	
	@MessageMapping("/mywebsockets")
    @SendTo("/topic/messages")
    public OutputMessage send(@Payload Message message) {
		
		System.out.println(message);
		
        return new OutputMessage(message.getFrom(), message.getText(), LocalDate.now());
    }
	

}
