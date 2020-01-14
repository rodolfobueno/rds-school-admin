package br.com.rdschool.admin.amqp;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(RDSExchange.class)
public class RDSPublisher {
	
	private static final Logger LOG = LoggerFactory.getLogger(RDSPublisher.class);

	@Autowired
	private RDSExchange exchange;
	
	public <T> void publish(T event) {
		Field field;
		String eventName = null;
		try {
			field = event.getClass().getField("NAME");
			eventName = (String) field.get(event);
			
			new TOTVSMessage<T>(eventName, event).sendTo(exchange.output());
			
		} catch (Exception e) {
			LOG.debug("Exchange: {}\nTopic: {}\n", exchange, eventName);
		}		
	}
}
