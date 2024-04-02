package com.d4u.Decision4You.fixtures;

import com.d4u.Decision4You.domain.project.Vote;

public class VoteFixture {

    // some random vote
    public static final String PROJECT_ID = "project-id";
    public static final String VOTER_ID = "voter-id";
    public static final double[][] VOTE = new double[][]{{1, 2}, {0.5, 1}};

    public static Vote createVote() {
        return new Vote(PROJECT_ID, VOTER_ID, VOTE);
    }
}
