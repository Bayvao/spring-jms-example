package com.jms.example.receiver;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.jms.example.config.jmsconfig.JmsConfiguration;
import com.jms.example.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloMessageReceiver {

	private final JmsTemplate jmsTemplate;
	
	@JmsListener(destination = JmsConfiguration.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage,
			@Headers MessageHeaders header, Message message) {
		
//		System.out.println("I got a message");
//		
//		System.out.println(helloWorldMessage);
//		
//		System.out.println("message: " + message);
		
	}
	
	 @SuppressWarnings("rawtypes")
	@JmsListener(destination = JmsConfiguration.MY_SEND_RCV_QUEUE)
	    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
	                       @Headers MessageHeaders headers, Message jmsMessage,
	                               org.springframework.messaging.Message springMessage) throws JMSException {

	        HelloWorldMessage payloadMsg = HelloWorldMessage
	                .builder()
	                .id(1L)
	                .message("World!!")
	                .build();

	        //example to use Spring Message type
	       // jmsTemplate.convertAndSend((Destination) springMessage.getHeaders().get("jms_replyTo"), "got it!");

	        jmsTemplate.convertAndSend(jmsMessage.getJMSReplyTo(), payloadMsg);

	    }

}
