package br.com.lfelipels.emailservice.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfelipels.emailservice.dtos.MailMessageDto;
import br.com.lfelipels.emailservice.rabbitmq.QueueNameEnum;
import contracts.SendMailContract;

@Service
public class SendMailQueue implements SendMailContract {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(MailMessageDto messageDto) {
        this.rabbitTemplate.convertAndSend(
            QueueNameEnum.MAIL_QUEUE, 
            messageDto
        );
    }
}
