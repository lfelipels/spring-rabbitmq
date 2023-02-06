package br.com.lfelipels.emailservice.rabbitmq.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfelipels.emailservice.dtos.MailMessageDto;
import br.com.lfelipels.emailservice.rabbitmq.QueueNameEnum;
import br.com.lfelipels.emailservice.services.SendMail;

@Service
public class MailConsumer {

    @Autowired
    private SendMail sendMail;

    @RabbitListener(queues = QueueNameEnum.MAIL_QUEUE)
    public void consume(MailMessageDto messageDto) throws InterruptedException {
        //simula um tempo para envio dos emails
        Thread.sleep(5*1000);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Enviando emails");
                sendMail.send(messageDto);
            }
        });
        t1.start();
    }
}
