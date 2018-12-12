package com.github.ka4ok85.wcatransactads.serializers;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.ka4ok85.wcatransactads.dtos.input.DeviceIncomingRequest;
import com.github.ka4ok85.wcatransactads.dtos.input.IncomingRequest;
import com.github.ka4ok85.wcatransactads.dtos.input.UserIncomingRequest;

@Configuration
public class IncomingRequestDeserializer extends JsonDeserializer<IncomingRequest> {

	@Override
	public IncomingRequest deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		TreeNode node = p.readValueAsTree();

		// Select the concrete class based on the existence of a property
		if (node.get("name") != null) {
			return p.getCodec().treeToValue(node, UserIncomingRequest.class);
		}

		return p.getCodec().treeToValue(node, DeviceIncomingRequest.class);
	}
}
