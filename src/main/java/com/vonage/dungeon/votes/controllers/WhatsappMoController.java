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
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<VotesSummary> postWhatsappMoMessage(@RequestBody String whatsappMoMessageJson) {
        System.out.println("got whatsapp mo: " + whatsappMoMessageJson);
        String text = getTextFromWhatsappMoJson(whatsappMoMessageJson);
        System.out.println("got text from whatsapp mo: " + text);

        VoteSummary voteSummary = whatsappMoMessageProcessor.process(text);
        System.out.println("got vote summary from whatsapp mo: " + voteSummary);
        votesRepository.storeVote(voteSummary);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/message-status")
    public ResponseEntity<String> returnOkForMessageStatus(@RequestBody String body) {
        System.out.println("something called message status with body: " + body);
        return ResponseEntity.ok().build();
    }

    private String getTextFromWhatsappMoJson(String whatsappMoMessageJson) {

        JSONObject whatsappMoMessageJsonObject = new JSONObject(whatsappMoMessageJson);

        return whatsappMoMessageJsonObject.getJSONObject("message")
                                          .getJSONObject("content")
                                          .getString("text");
    }
}
