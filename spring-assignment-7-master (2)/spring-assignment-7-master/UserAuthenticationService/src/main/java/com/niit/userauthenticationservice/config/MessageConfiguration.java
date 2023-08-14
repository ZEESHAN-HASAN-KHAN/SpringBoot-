package com.niit.userauthenticationservice.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.DirectExchange;
@Configuration
    public class MessageConfiguration {

    private String exchangeName="user_exchange";
    private String registerQueue="user_queue";

    @Bean
        public Jackson2JsonMessageConverter jsonMessageConverter()
        {

            return new Jackson2JsonMessageConverter();
        }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(exchangeName);
    }
    @Bean
    public Queue registerQueue()
    {
        return new Queue(registerQueue,true);
    }


    @Bean
    Binding bindingUser(DirectExchange exchange,Queue registerQueue)
    {
        return BindingBuilder.bind(registerQueue()).to(exchange).with("user_routing");
    }


}


