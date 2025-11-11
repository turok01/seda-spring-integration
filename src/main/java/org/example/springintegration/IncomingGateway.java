package org.example.springintegration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.Map;

@MessagingGateway
public interface IncomingGateway {
    @Gateway(requestChannel = "receiveTextChannel", replyChannel = "returnResponseChannel")
    public Map<String, Long> countWords(String input);
}
