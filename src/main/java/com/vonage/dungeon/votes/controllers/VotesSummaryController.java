package com.vonage.dungeon.votes.controllers;

import com.vonage.dungeon.votes.domain.Counters;
import com.vonage.dungeon.votes.domain.VotesSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class VotesSummaryController {

    private final Counters votesRepository;

    @Autowired
    public VotesSummaryController(Counters votesRepository) {
        this.votesRepository = votesRepository;
    }

    @GetMapping("/votes")
    public ResponseEntity<VotesSummary> getRecentVotes() {
        return ResponseEntity.ok().body(votesRepository.getVotesSummary());
    }
}
