package com.d4u.Decision4You.presentation.views;

import java.util.List;
import java.util.Set;

public abstract class Views {

    public record UserRegisteredView(
            String userId
    ) {
    }

    public record ProjectCreatedView(
            String projectId
    ) {
    }

    public record VoteProcessedView(
            String voteId,
            double[] scores
    ) {
    }

    public record UserView(
            String id,
            String email,
            String firstName,
            String lastName
    ) {
    }

    public record ProjectView(
            String id,
            String creatorId,
            String title,
            String description,
            Set<String> alternatives,
            Set<String> criteria
    ) {
    }

    public record LoginView(
            UserView authUser,
            List<UserView> otherUsers,
            List<ProjectView> createdProjects,
            List<ProjectView> invitedProjects
    ) {
    }
}
