package multicam6.smartPot.controller;

import lombok.RequiredArgsConstructor;
import multicam6.smartPot.service.SqsMessageSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SqsController {
    private final SqsMessageSender messageSender;

    @PostMapping("/message")
    public void sendMessage(@RequestBody String message) {
        messageSender.sendMessage(message);
    }
}
