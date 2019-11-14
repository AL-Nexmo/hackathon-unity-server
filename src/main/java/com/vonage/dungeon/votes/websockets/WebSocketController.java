package com.vonage.dungeon.votes.websockets;

import com.vonage.dungeon.votes.domain.VoteSummary;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @SendTo("/socket")
    public VoteSummary sendMessage(VoteSummary message) {
        return message;
    }
}

