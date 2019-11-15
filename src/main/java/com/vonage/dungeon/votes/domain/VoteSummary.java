package com.vonage.dungeon.votes.domain;

public class VoteSummary {

    private VoteAction action;

    public VoteSummary(VoteAction action) {
        this.action = action;
    }

    public VoteAction getAction() {
        return action;
    }

    public void setAction(VoteAction action) {
        this.action = action;
    }

    public enum VoteAction {
        UP, DOWN, LEFT, RIGHT, DISCARD
    }
}
