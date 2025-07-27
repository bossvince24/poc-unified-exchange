package poc.example.Withdrawal.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.rabbitmq.exchange.name}")
	public String exchangeName;
	
	@Value("${spring.rabbitmq.routing-key}")
	public String routingKey;
	
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(exchangeName);
	}

}
