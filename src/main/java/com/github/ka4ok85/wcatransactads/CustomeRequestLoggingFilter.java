package com.github.ka4ok85.wcatransactads;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class CustomeRequestLoggingFilter extends CommonsRequestLoggingFilter {

	public CustomeRequestLoggingFilter() {
		super.setIncludeQueryString(true);
		super.setIncludePayload(true);
		super.setMaxPayloadLength(10000);
	}
}
