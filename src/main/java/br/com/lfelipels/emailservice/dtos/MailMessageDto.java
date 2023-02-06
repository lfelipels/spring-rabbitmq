package br.com.lfelipels.emailservice.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailMessageDto implements Serializable {
    
    private String to;
    private String subject;
    private String body;
}
