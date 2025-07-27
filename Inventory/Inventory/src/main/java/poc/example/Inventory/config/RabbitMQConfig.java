package poc.example.Inventory.config;

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
	public DirectExchange inventoryExchange() {
		return new DirectExchange(unifiedExchange);
	}

	@Bean
	public Queue inventoryQueue() {
		return new Queue(queueName, true);
	}

	@Bean
	public Binding inventoryQueueBinding() {
		return BindingBuilder.bind(inventoryQueue()).to(inventoryExchange()).with(routingKey);
	}

	@Bean
	public Binding depositToInventoryBinding() {
		return new Binding(unifiedExchange, Binding.DestinationType.EXCHANGE, depositExchange, routingKey, null);
	}
	
	@Bean
	public Binding withdrawalToInventoryBinding() {
		return new Binding(unifiedExchange, Binding.DestinationType.EXCHANGE, withdrawalExchange, routingKey, null);
	}
}
