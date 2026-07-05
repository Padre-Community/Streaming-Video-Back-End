package api.core.video_max.modules.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("-");
    }

    @Bean
    Queue methode() {
        return new Queue("-", true);
    }

    @Bean
    Binding bindingPlan() {
        return BindingBuilder.bind(methode()).to(directExchange()).with("-");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
