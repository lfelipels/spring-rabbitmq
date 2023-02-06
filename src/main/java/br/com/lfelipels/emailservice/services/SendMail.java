package br.com.lfelipels.emailservice.services;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.com.lfelipels.emailservice.dtos.MailMessageDto;

@Service
public class SendMail {

    private MailSender mailSender;

    SendMail(MailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void send(MailMessageDto message) {
        System.out.println(String.format(
            "Enviando email para %s",
            message.getTo()
        ));

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(message.getTo());
        msg.setSubject(message.getSubject());
        msg.setText(message.getBody());
        this.mailSender.send(msg);
    }

}
