package com.vonage.dungeon.votes.repository;

import com.vonage.dungeon.votes.domain.VotesSummary;
import org.springframework.stereotype.Component;

@Component
public class VotesRepository {
    public VotesSummary getVotesSummary() {
        return VotesSummary.builder()
                           .withUpVotes(1)
                           .withLeftVotes(2)
                           .withRightVotes(3)
                           .withDownVotes(4)
                           .build();
    }
}
