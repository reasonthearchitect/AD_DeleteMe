package com.tek.myservice.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface CatMetadata {
	 
		@Output("cat")
    	MessageChannel post();
}