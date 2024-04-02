package com.d4u.Decision4You.presentation;

import com.d4u.Decision4You.presentation.commands.Commands;
import com.d4u.Decision4You.presentation.views.Views;
import com.d4u.Decision4You.security.web.SecurityUser;
import com.d4u.Decision4You.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor

public class ProjectController {

    // private final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
    private final ProjectService projectService;

    /**
     * Creates a new project.
     *
     * @param command the project creation command
     * @return 201 Created with the created project view and the location header
     */
    @PostMapping
    public ResponseEntity<Views.ProjectCreatedView> createProject(
            @AuthenticationPrincipal SecurityUser principal,
            @RequestBody Commands.ProjectCreationCommand command
    ) {
        var view = projectService.createProject(principal.getUser(), command);

        // Creates the location header
        URI uri = URI.create("/api/project/" + view.projectId());
        return ResponseEntity.created(uri).body(view);
    }


    /**
     * Votes for a given project.
     *
     * @param command the vote command
     * @return 201 Created with the created vote view
     */
    @PostMapping("{projectId}/vote")
    public Views.VoteProcessedView voteProject(
            @AuthenticationPrincipal SecurityUser principal,
            @RequestBody Commands.ProjectVoteCommand command
    ) {
        var view = projectService.voteProject(principal.getUser(), command);

        // No need to return a location header here, as the vote is not a resource
        return view;
    }
}
