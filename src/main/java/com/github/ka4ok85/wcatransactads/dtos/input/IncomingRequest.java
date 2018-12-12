package com.github.ka4ok85.wcatransactads.dtos.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.ka4ok85.wcatransactads.serializers.IncomingRequestDeserializer;

@JsonDeserialize(using = IncomingRequestDeserializer.class)
public abstract class IncomingRequest {
	private String q;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public String toString() {
		return "IncomingRequest [q=" + q + "]";
	}

}
