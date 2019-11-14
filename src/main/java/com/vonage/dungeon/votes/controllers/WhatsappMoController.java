package com.vonage.dungeon.votes.controllers;

import com.vonage.dungeon.votes.domain.Counters;
import com.vonage.dungeon.votes.domain.VoteSummary;
import com.vonage.dungeon.votes.domain.VotesSummary;
import com.vonage.dungeon.votes.processors.MoMessageProcessor;
import com.vonage.dungeon.votes.processors.WhatsappMoMessageProcessor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class WhatsappMoController {

    private final Counters votesRepository;
    private final WhatsappMoMessageProcessor whatsappMoMessageProcessor;


    @Autowired
    public WhatsappMoController(Counters votesRepository, WhatsappMoMessageProcessor whatsappMoMessageProcessor) {
        this.votesRepository = votesRepository;
        this.whatsappMoMessageProcessor = whatsappMoMessageProcessor;
    }

    @PostMapping("/whatsapp-mo-messages")
    public ResponseEntity<VotesSummary> postWhatsappMoMessage(String whatsappMoMessageJson) {

        String text = getTextFromWhatsappMoJson(whatsappMoMessageJson);

        VoteSummary voteSummary = whatsappMoMessageProcessor.process(text);
        votesRepository.storeVote(voteSummary);
        return ResponseEntity.ok().build();
    }

    private String getTextFromWhatsappMoJson(String whatsappMoMessageJson) {

        JSONObject whatsappMoMessageJsonObject = new JSONObject(whatsappMoMessageJson);

        return whatsappMoMessageJsonObject.getJSONObject("message")
                                          .getJSONObject("content")
                                          .getString("text");
    }
}
