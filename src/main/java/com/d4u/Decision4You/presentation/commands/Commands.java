package com.d4u.Decision4You.presentation.commands;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Commands {

    public record UserRegistrationCommand(
            String email,
            String password,
            String firstName,
            String lastName
    ) {
        public UserRegistrationCommand {
            email = email.trim().toLowerCase();
        }
    }


    public record ProjectCreationCommand(
            String title,
            String description,
            Set<String> votersIds,
            LinkedHashSet<String> alternatives,
            LinkedHashSet<String> criteria,
            int[][] alternativeJudgements
    ) {
        public ProjectCreationCommand {
            title = title.trim();
            description = description.trim();
        }
    }

    public record ProjectVoteCommand(
            String projectId,
            double[][] votes
    ) {
    }
}
