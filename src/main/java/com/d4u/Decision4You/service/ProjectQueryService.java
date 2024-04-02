package com.d4u.Decision4You.service;


import com.d4u.Decision4You.domain.project.Project;
import com.d4u.Decision4You.domain.project.Vote;
import com.d4u.Decision4You.persistence.ProjectRepository;
import com.d4u.Decision4You.persistence.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProjectQueryService {

    private final ProjectRepository projectRepository;
    private final VoteRepository voteRepository;

    private static RuntimeException ofProjectNotFound(String projectId) {
        return new IllegalArgumentException("Project not found with id " + projectId);
    }

    public Project findById(String projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> ofProjectNotFound(projectId));
    }

    public List<Project> findAllMyCreated(String userId) {
        return projectRepository.findAllByCreatorId(userId);
    }

    public List<Project> findAllMyInvited(String userId) {
        return projectRepository.findAllByVoterIdsContaining(userId);
    }

    public boolean hasUserVoted(String projectId, String userId) {
        return voteRepository.existsByProjectIdAndVoterId(projectId, userId);
    }

    public boolean hasUserNotVoted(String projectId, String userId) {
        return ! hasUserVoted(projectId, userId);
    }

    public List<Vote> findAllVotes(String projectId) {
        return voteRepository.findAllByProjectId(projectId);
    }
}
