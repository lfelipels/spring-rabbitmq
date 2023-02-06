package br.com.lfelipels.emailservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lfelipels.emailservice.dtos.MailMessageDto;
import contracts.SendMailContract;

@RestController
@RequestMapping(path = "mails")
public class MailController {

    @Autowired
    private SendMailContract sendMail;

    @ResponseBody
    @PostMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
    public void send(
        @RequestBody MailMessageDto messageDto
    ) throws Exception {
        try {
            this.sendMail.send(messageDto);
        } catch (Exception e) {
            throw new Exception("Não foi possível enviar o email");
        }
    }
}
