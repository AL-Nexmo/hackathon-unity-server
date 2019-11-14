package com.vonage.dungeon.votes.domain;

public class VotesSummary {

    private int upVotes;
    private int downVotes;
    private int leftVotes;
    private int rightVotes;

    public VotesSummary(int upVotes, int downVotes, int leftVotes, int rightVotes) {
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.leftVotes = leftVotes;
        this.rightVotes = rightVotes;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private int upVotes;
        private int downVotes;
        private int leftVotes;
        private int rightVotes;

        public Builder withLeftVotes(int leftVotes) {
            this.leftVotes = leftVotes;
            return this;
        }

        public Builder withRightVotes(int rightVotes) {
            this.rightVotes = rightVotes;
            return this;
        }

        public Builder withUpVotes(int upVotes) {
            this.upVotes = upVotes;
            return this;
        }

        public Builder withDownVotes(int downVotes) {
            this.downVotes = downVotes;
            return this;
        }

        public VotesSummary build() {
            return new VotesSummary(upVotes, downVotes, leftVotes, rightVotes);
        }
    }
}
