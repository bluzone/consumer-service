package com.bluvision.consumer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;

/**
 * Simple programmatic websocket client based on Tyrus.  The implementation demonstrates
 * a custom implementation of the ClientEndpointConfig.Configurator to provide custom
 * headers - in this case, the BZID auth token header.
 *
 * @author dare
 * @since 1.0
 */
public class ConsumerClient extends Endpoint {

	private Logger log = LoggerFactory.getLogger(ConsumerClient.class);

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		session.addMessageHandler(new MessageHandler.Whole<String>() {
			public void onMessage(String text) {
				log.info("--> {}", text);
			}
		});
	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {
		super.onClose(session, closeReason);
	}

	@Override
	public void onError(Session session, Throwable thr) {
		super.onError(session, thr);
	}
}
