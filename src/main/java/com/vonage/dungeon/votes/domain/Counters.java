package com.vonage.dungeon.votes.domain;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public final class Counters {
    public static AtomicInteger up = new AtomicInteger();
    public static AtomicInteger down = new AtomicInteger();
    public static AtomicInteger left = new AtomicInteger();
    public static AtomicInteger right = new AtomicInteger();

    public void storeVote(VoteSummary voteSummary) {

        switch (voteSummary.getAction()) {
            case UP:
                up.incrementAndGet();
            case DOWN:
                down.incrementAndGet();
            case LEFT:
                left.incrementAndGet();
            case RIGHT:
                right.incrementAndGet();
            default:
                System.out.println("Discarded message");
        }
    }

    public VotesSummary getVotesSummary() {

        int upVotes = up.getAndSet(0);
        int downVotes = down.getAndSet(0);
        int leftVotes = left.getAndSet(0);
        int rightVotes = right.getAndSet(0);

        return new VotesSummary(upVotes, downVotes, leftVotes, rightVotes);
    }
}
