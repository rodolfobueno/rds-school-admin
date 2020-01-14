package br.com.rdschool.admin.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RDSExchange {

	public static final String OUTPUT = "rds-output-events";
	
	@Output(RDSExchange.OUTPUT)
	MessageChannel output();
	
}
