package com.github.ka4ok85.wcatransactads.services;

import java.util.Map;

import com.github.ka4ok85.wcatransactads.dtos.input.IncomingRequest;

public interface IncomingRequestService {

	Map<String, String> parseRequest(IncomingRequest incomingRequest);

}
