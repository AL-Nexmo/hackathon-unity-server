package com.vonage.dungeon.votes.processors;

import com.vonage.dungeon.votes.domain.VoteSummary;
import org.springframework.stereotype.Component;

@Component
public class WhatsappMoMessageProcessor {

    public VoteSummary process(String text) {

        VoteSummary.VoteAction action = null;
        switch (text.toLowerCase().trim()) {
            case "up":
                action = VoteSummary.VoteAction.UP;
                break;
            case "down":
                action = VoteSummary.VoteAction.DOWN;
                break;
            case "left":
                action = VoteSummary.VoteAction.LEFT;
                break;
            case "right":
                action = VoteSummary.VoteAction.RIGHT;
                break;
            default:
                action = VoteSummary.VoteAction.DISCARD;
        }

        return new VoteSummary(action);
    }
}
