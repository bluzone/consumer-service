package com.bluvision.consumer.client;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.HandshakeResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * WebSocket Client Configurator implementation that enables setting a custom
 * header, in this case the API Token.
 *
 * @author dare
 * @since 1.0
 */
public class CustomConfigurator extends ClientEndpointConfig.Configurator {

	static volatile boolean called = false;

	private final String apiToken;

	public CustomConfigurator(String apiToken) {
		this.apiToken = apiToken;
	}

	@Override
	public void beforeRequest(Map<String, List<String>> headers) {
		called = true;
		headers.put("BZID", Arrays.asList(apiToken));
		super.beforeRequest(headers);
	}

	@Override
	public void afterResponse(HandshakeResponse hr) {
		super.afterResponse(hr);
	}
}
