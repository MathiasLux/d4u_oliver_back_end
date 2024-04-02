package com.d4u.Decision4You.persistence;

import com.d4u.Decision4You.domain.project.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {

    List<Vote> findAllByProjectId(String projectId);

    boolean existsByProjectIdAndVoterId(String projectId, String voterId);
}
