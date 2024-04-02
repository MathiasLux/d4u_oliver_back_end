package com.d4u.Decision4You.fixtures;

import com.d4u.Decision4You.presentation.commands.Commands;

import static com.d4u.Decision4You.fixtures.ProjectFixture.*;
import static com.d4u.Decision4You.fixtures.UserFixture.*;

public class CommandFixtures {

    // This fixtures are used to test the commands in the presentation layer.

    // They are using the fixtures from the domain layer.
    // e.g. ProjectFixture, UserFixture, VoteFixture

    public static final Commands.UserRegistrationCommand USER_REGISTRATION_COMMAND =
            new Commands.UserRegistrationCommand(
                    EMAIL1, PASSWORD, FIRST_NAME, LAST_NAME);

    public static final Commands.ProjectCreationCommand PROJECT_CREATION_COMMAND =
            new Commands.ProjectCreationCommand(
                    TITLE, DESCRIPTION, VOTER_IDS, ALTERNATIVES, CRITERIA, ALTERNATIVE_JUDGMENTS);

    public static ProjectVoteCommandBuilder PROJECT_VOTE_COMMAND =
            new ProjectVoteCommandBuilder();

    public static class ProjectVoteCommandBuilder {
        public Commands.ProjectVoteCommand withProjectId(String projectId) {
            return new Commands.ProjectVoteCommand(projectId, CRITERIA_ASSESSMENT);
        }
    }
}
