package com.bluvision.consumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Consumer Client application context entry point.
 *
 * @author dare (robert@bluvision.com)
 * @since 1.0
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(Application.class);

	@Value("${client.apiToken}")
	protected String apiToken;

	@Value("${client.apiUrl}")
	protected String apiUrl;

	protected Session session;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		log.info("Starting...");
		log.info("-- API URL:  {}", apiUrl);
		log.info("-- API Token:  {}", apiToken);
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		ClientEndpointConfig config = ClientEndpointConfig
				.Builder.create()
				.configurator(new CustomConfigurator(apiToken))
				.build();
		try {
			session = container.connectToServer(ConsumerClient.class, config, URI.create(apiUrl));
		} catch (DeploymentException de) {
			log.error("Failed to connect - DeploymentException:", de);
		} catch (IOException ioe) {
			log.error("IOException:", ioe);
		}
		if (this.session == null) {
			throw new RuntimeException("Unable to connect to endpoint.");
		}
		log.info("Connected.");
		log.info("Type \"exit\" to cancel.");
		log.info("...Waiting for data...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		try {
			do {
				input = br.readLine();
				if (!input.equals("exit")) {
					this.session.getBasicRemote().sendText(input);
				}
			} while (!input.equals("exit"));
		} catch (IOException e) {
			log.error("IOException:", e);
		}
	}

}