package com.vonage.dungeon.votes.controllers;

import com.vonage.dungeon.votes.websockets.VotesWebsocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class MoMessagesController {

    private final VotesWebsocket votesWebsocket;

    @Autowired
    public MoMessagesController(VotesWebsocket votesWebsocket) {
        this.votesWebsocket = votesWebsocket;
    }

    @PostMapping("/mo-messages")
    public ResponseEntity<String> postVotesSummary(@RequestBody String json) {
        return processMo(json);
    }

    private ResponseEntity<String> processMo(String json) {
        System.out.println(json);
        return ResponseEntity.ok().build();
    }

}
