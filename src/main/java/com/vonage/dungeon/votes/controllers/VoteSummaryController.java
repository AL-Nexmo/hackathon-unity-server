package com.vonage.dungeon.votes.controllers;

import com.vonage.dungeon.votes.domain.VotesSummary;
import com.vonage.dungeon.votes.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class VoteSummaryController {

    private final VotesRepository votesRepository;

    @Autowired
    public VoteSummaryController(VotesRepository votesRepository) {
        this.votesRepository = votesRepository;
    }

    @GetMapping("/votes")
    public String getVotesSummary() {
        return "hi";
//        return votesRepository.getVotesSummary();
    }

}
