package poc.example.Notification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.exchange.unified}")
	public String unifiedExchange;

	@Value("${spring.rabbitmq.queue.name}")
	public String queueName;

	@Value("${spring.rabbitmq.routing-key}")
	public String routingKey;

	@Value("${spring.rabbitmq.exchange.deposit}")
	public String depositExchange;

	@Value("${spring.rabbitmq.exchange.withdrawal}")
	public String withdrawalExchange;

	@Bean
	public DirectExchange notificationExchange() {
		return new DirectExchange(unifiedExchange);
	}

	@Bean
	public Queue notificationQueue() {
		return new Queue(queueName, true);
	}

	@Bean
	public Binding notificationQueueBinding() {
		return BindingBuilder.bind(notificationQueue()).to(notificationExchange()).with(routingKey);
	}

	@Bean
	public Binding depositToNotificationBinding() {
		return new Binding(unifiedExchange, Binding.DestinationType.EXCHANGE, depositExchange, routingKey, null);
	}

	@Bean
	public Binding withdrawalToNotificationBinding() {
		return new Binding(unifiedExchange, Binding.DestinationType.EXCHANGE, withdrawalExchange, routingKey, null);
	}

}
