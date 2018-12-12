package com.github.ka4ok85.wcatransactads.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.ka4ok85.wcatransactads.dtos.input.DeviceIncomingRequest;
import com.github.ka4ok85.wcatransactads.dtos.input.IncomingRequest;
import com.github.ka4ok85.wcatransactads.dtos.input.UserIncomingRequest;
import com.github.ka4ok85.wcatransactads.services.AuthService;
import com.github.ka4ok85.wcatransactads.services.ContentService;
import com.github.ka4ok85.wcatransactads.services.IncomingRequestService;
import com.github.ka4ok85.wcatransactads.services.ProcessorService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class RequestController<T extends IncomingRequest> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private IncomingRequestService incomingRequestService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ProcessorService processorService;
	
	//@Autowired RedisTemplate<String, Object> redisTemplate;
	
	/*
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String helloSleuth(@RequestBody IncomingRequest incomingRequest) {
        logger.info("Hello Sleuth");
        
        
        //String value = "{\"file\":\"\\/cisdata\\/devel\\/emakove\\/clients\\/evgeny\\/elk\\/vendor\\/silverpop\\/cislib\\/bin\\/run_job\",\"zone\":\"spoofed\",\"category\":\"clients\",\"customer\":\"evgeny\",\"project\":\"elk\",\"branch\":null,\"fullProject\":\"clients.evgeny.elk\",\"@timestamp\":\"2018-11-28T21:45:02.000+0000\",\"@version\":1,\"localTime\":\"2018-11-28 16:45:02\",\"host\":\"vcisdev11.atlis1\",\"type\":\"cis\",\"tags\":[\"cis\",\"cis_test\",\"cis\"],\"processOwner\":\"cisuser\",\"phpType\":\"cli\",\"timewarped\":\"no\",\"message\":\"pod 6 API method get access token call\",\"channel\":\"pod 6 API\",\"level\":\"ERROR\",\"pod\":\"pod6\",\"method\":\"test method\",\"request\":\"req\",\"response\":\"resp\",\"error\":\"err\"}";
        //String key = "logstash";
        //redisTemplate.opsForList().rightPush(key,value);

        authService.authorize("");
        
        incomingRequestService.verifyRequest(incomingRequest);
        
        logger.info("Buy Sleuth");
        return "success";
    }
    */
 
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> create(@RequestBody IncomingRequest incomingRequest) {
        
    	logger.info("Hello Sleuth");
    	logger.info("create() with body {} of type {}", incomingRequest, incomingRequest.getClass());


    	
    	
        authService.authorize(""); // TODO: 
        
        Map<String, String> input = incomingRequestService.parseRequest(incomingRequest); // TODO:
        
        Map<String, String> content = contentService.loadData(incomingRequest);
        
        processorService.enhance(input, content);
        
        logger.info("Buy Sleuth");
        /*
        IncomingRequest input = (IncomingRequest) json;
        System.out.println(input);
        System.out.println(input.getClass());
        */
        //System.out.println(input.get("name"));
        
        //T created = this.repo.save(json);
        /*
        T created = (T) new Object();

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", true);
        m.put("created", created);
        
        return m;
        */
        return null;
    }
}
