package com.vonage.dungeon.votes.processors;

import com.vonage.dungeon.votes.domain.MoMessage;
import com.vonage.dungeon.votes.domain.VoteSummary;
import org.springframework.stereotype.Component;

@Component
public class MoMessageProcessor {

    public VoteSummary process(MoMessage moMessage) {
        System.out.println(moMessage);
        return new VoteSummary(VoteSummary.VoteAction.UP);
    }
}
