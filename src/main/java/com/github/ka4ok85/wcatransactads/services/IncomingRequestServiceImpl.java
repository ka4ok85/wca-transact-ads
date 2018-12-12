package com.github.ka4ok85.wcatransactads.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.ka4ok85.wcatransactads.dtos.input.IncomingRequest;

public class IncomingRequestServiceImpl implements IncomingRequestService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Map<String, String> parseRequest(final IncomingRequest incomingRequest) {
		logger.info("IncomingRequestServiceImpl verifyRequest()");

		for (Method method : incomingRequest.getClass().getMethods())
			if (method.getName().startsWith("get") && method.getParameterTypes().length == 0
					&& !method.getName().equals("getClass")) {
				try {
					final String getterResult = (String) method.invoke(incomingRequest);
					System.out.println(method.getName());
					System.out.println(getterResult);
					System.out.println(getterResult.getClass());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		return null;

	}

}
