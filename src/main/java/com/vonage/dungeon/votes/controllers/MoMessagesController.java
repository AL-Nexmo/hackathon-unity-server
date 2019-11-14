package com.vonage.dungeon.votes.controllers;

import com.vonage.dungeon.votes.domain.Counters;
import com.vonage.dungeon.votes.domain.MoMessage;
import com.vonage.dungeon.votes.domain.VoteSummary;
import com.vonage.dungeon.votes.processors.MoMessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class MoMessagesController {

    private final MoMessageProcessor moMessageProcessor;
    private final Counters votesRepository;

    @Autowired
    public MoMessagesController(MoMessageProcessor moMessageProcessor, Counters votesRepository) {
        this.moMessageProcessor = moMessageProcessor;
        this.votesRepository = votesRepository;
    }

    @PostMapping("/mo-messages")
    public ResponseEntity<String> postVotesSummary(@RequestBody MoMessage moMessage) {
        return processMo(moMessage);
    }

    private ResponseEntity<String> processMo(MoMessage moMessage) {
        VoteSummary voteSummary = moMessageProcessor.process(moMessage);
        votesRepository.storeVote(voteSummary);
        return ResponseEntity.ok().build();
    }

}
