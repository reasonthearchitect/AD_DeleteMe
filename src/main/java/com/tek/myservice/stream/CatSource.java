package com.tek.myservice.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.tek.myservice.dto.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;
import lombok.extern.java.Log;

@Log
@Component
@EnableBinding(CatMetadata.class)
public class CatSource {

        @Autowired @Qualifier("cat")
        private MessageChannel post;

        @Autowired
        ObjectMapper mapper;

        public void send(Cat cat) {
                try {
                        Message<?> message = MessageBuilder.withPayload(
                                        mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cat)
                                )
                                .setHeader("contentType", "application/json")
                                .build();
                        post.send(message);
                } catch (Exception ex) {
                        log.log(Level.SEVERE, "Error trying to send a message to a queue: ", ex);
                }        
        }

}
