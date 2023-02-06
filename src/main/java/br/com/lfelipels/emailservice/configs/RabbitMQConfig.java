package br.com.lfelipels.emailservice.configs;

import org.springframework.amqp.core.AbstractExchange;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lfelipels.emailservice.rabbitmq.QueueNameEnum;
import jakarta.annotation.PostConstruct;

@Configuration
public class RabbitMQConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    private Binding makeBinding(Queue mailQueue, Exchange directExchange) {
        return new Binding(mailQueue.getName(), 
        Binding.DestinationType.QUEUE, directExchange.getName(), mailQueue.getName(), null);
    }


    @PostConstruct
    public AmqpAdmin amqpAdmin() {        
        Queue mailQueue = new Queue(QueueNameEnum.MAIL_QUEUE, true, false, false);
        Exchange directExchange = new DirectExchange("amq.direct");
        Binding bindingWithMailQueue = this.makeBinding(mailQueue, directExchange);
        this.amqpAdmin.declareQueue(mailQueue);
        this.amqpAdmin.declareExchange(directExchange);        
        this.amqpAdmin.declareBinding(bindingWithMailQueue);
        return this.amqpAdmin;
    }

}
