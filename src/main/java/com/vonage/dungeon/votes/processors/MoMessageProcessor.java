package com.vonage.dungeon.votes.processors;

import com.vonage.dungeon.votes.domain.MoMessage;
import com.vonage.dungeon.votes.domain.VoteSummary;
import com.vonage.dungeon.votes.domain.VotesSummary;
import org.springframework.stereotype.Component;

@Component
public class MoMessageProcessor {

    public VoteSummary process(MoMessage moMessage) {
        System.out.println(moMessage);
        String text = moMessage.getText().trim();

        VoteSummary.VoteAction action = null;
        switch (text.toLowerCase()) {
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
