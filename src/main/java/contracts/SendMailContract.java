package contracts;

import br.com.lfelipels.emailservice.dtos.MailMessageDto;

public interface SendMailContract {    
    public void send(MailMessageDto messageDto);
}
