package com.github.ka4ok85.wcatransactads.services;

import java.util.Map;

import com.github.ka4ok85.wcatransactads.dtos.input.IncomingRequest;

public interface ProcessorService {
	Map<String, String> enhance(Map<String, String> input, Map<String, String> content);
}
