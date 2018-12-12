package com.github.ka4ok85.wcatransactads.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;

import com.github.ka4ok85.wcatransactads.services.AuthService;
import com.github.ka4ok85.wcatransactads.services.AuthServiceImpl;
import com.github.ka4ok85.wcatransactads.services.ContentService;
import com.github.ka4ok85.wcatransactads.services.ContentServiceImpl;
import com.github.ka4ok85.wcatransactads.services.IncomingRequestService;
import com.github.ka4ok85.wcatransactads.services.IncomingRequestServiceImpl;
import com.github.ka4ok85.wcatransactads.services.ProcessorService;
import com.github.ka4ok85.wcatransactads.services.ProcessorServiceImpl;

@Configuration
public class SpringConfig {

	@Bean
	public AuthService authService() {
		return new AuthServiceImpl();
	}

	@Bean
	public IncomingRequestService incomingRequestService() {
		return new IncomingRequestServiceImpl();
	}

	@Bean
	public ContentService contentService() {
		return new ContentServiceImpl();
	}

	@Bean
	public ProcessorService processorService() {
		return new ProcessorServiceImpl();
	}



}
