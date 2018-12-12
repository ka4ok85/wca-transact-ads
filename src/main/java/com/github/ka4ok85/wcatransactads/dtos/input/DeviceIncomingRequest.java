package com.github.ka4ok85.wcatransactads.dtos.input;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
public class DeviceIncomingRequest extends IncomingRequest {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DeviceIncomingRequest [id=" + id + "]";
	}

}
