package app.messages;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private static MessageRepository repository;

    public MessageService (MessageRepository repository) {
        this.repository = repository;
    }

    public static Message save(String text) {
        return repository.saveMessage(new Message(text));
    }
    
}
