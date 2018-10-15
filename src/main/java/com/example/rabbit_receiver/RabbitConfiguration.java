package com.example.rabbit_receiver;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mmartofel on 10/15/18.
 */

@Configuration
public class RabbitConfiguration {

    @Bean
    public RabbitMessageReceiver rabbitMessageReceiver() {
        System.out.println("Bean rabbitMessageReceiver instantiated.");
        return new RabbitMessageReceiver();
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        System.out.println("Bean jsonMessageConverter instantiated.");
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

}
