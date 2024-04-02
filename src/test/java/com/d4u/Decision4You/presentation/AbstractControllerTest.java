package com.d4u.Decision4You.presentation;

import com.d4u.Decision4You.domain.project.Project;
import com.d4u.Decision4You.persistence.ProjectRepository;
import com.d4u.Decision4You.persistence.UserRepository;
import com.d4u.Decision4You.persistence.VoteRepository;
import com.d4u.Decision4You.presentation.helpers.ApiTester;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static com.d4u.Decision4You.fixtures.ProjectFixture.createProject;
import static com.d4u.Decision4You.fixtures.UserFixture.*;
import static com.d4u.Decision4You.fixtures.ProjectFixture.createProject;
import static com.d4u.Decision4You.fixtures.UserFixture.*;
import static java.util.Set.of;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


import static java.util.Set.of;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public abstract class AbstractControllerTest {

    @LocalServerPort private int port;

    @Autowired protected UserRepository userRepository;
    @Autowired protected ProjectRepository projectRepository;
    @Autowired protected VoteRepository voteRepository;

    protected ApiTester.AuthToken authToken;
    protected Project authUserProject;
    protected Project otherUserProject;

    @BeforeAll
    public void serverSetup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    protected void cleanAndPopulateDB() {
        userRepository.deleteAll();
        projectRepository.deleteAll();
        voteRepository.deleteAll();
        populateDB();
    }

    // We have 3 users and 2 projects
    // Authenticated user has 2 projects
    // Authenticated user is invited to 1 project
    private void populateDB() {
        // Create authenticated user token
        authToken = new ApiTester.AuthToken(EMAIL1, PASSWORD);

        // Create users
        var authUser = userRepository.save(createUser(EMAIL1));
        var otherUser1 = userRepository.save(createUser(EMAIL2));
        var otherUser2 = userRepository.save(createUser(EMAIL3));

        // Create a project owned by the authenticated user
        var voterIds = of(otherUser1.getId(), otherUser2.getId());
        authUserProject = projectRepository.save(createProject(authUser.getId(), voterIds));

        // Create a project owned by another user
        otherUserProject = projectRepository.save(createProject(otherUser1.getId(), of(authUser.getId())));
    }
}
