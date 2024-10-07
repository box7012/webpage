package app.messages;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/messages")
public class MessageController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("message", "Hello, Welcome to Spring Boot!");
        return "welcome";
    }
    
@PostMapping("/messages")
@ResponseBody
public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
    Message saved = MessageService.save(data.getText());
    
    if (saved == null) {
        return ResponseEntity.status(500).build();
    }
    
    return ResponseEntity.ok(saved);
}

public class MessageData {
    private String text;
    public String getText() {return this.text;}
    public void setText(String text) {this.text = text;}
}


    
}
