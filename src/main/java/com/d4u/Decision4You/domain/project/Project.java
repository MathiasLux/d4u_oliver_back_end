package com.d4u.Decision4You.domain.project;

import com.d4u.Decision4You.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

import static com.d4u.Decision4You.foundation.AssertUtil.*;
import static com.d4u.Decision4You.foundation.EntityUtil.generateUUIDv4;

@Getter
@ToString
@Document(collection = "project")
public class Project extends BaseEntity<String> {
    // Who created this project?
    @Indexed
    private String creatorId;

    // Who can vote in this project?
    @Indexed private Set<String> votersIds;

    // A short title of the project.
    private String title;

    // A longer description of the project.
    private String description;

    // The alternatives to be compared.
    private Set<String> alternatives;

    // The criteria to be used for the pairwise comparison.
    private Set<String> criteria;

    // The final score evaluation of the alternatives.
    @Setter
    private double[] finalEvaluation;


    // ctor --------------------------------------------

    // Constructor for Spring Data to use when creating a new user from DB into memory.
    // Spring Data uses reflection to create an instance of this class.
    @PersistenceCreator
    @JsonCreator
    protected Project(String id) {
        super(id);
    }

    // Constructor for us developers to use when creating a new user in memory.
    public Project(String creatorId, Set<String> voterIds, String title, String description,
                   Set<String> criteria, Set<String> alternatives) {
        super(generateUUIDv4());

        this.creatorId = isNotNull(creatorId, "creatorId");
        this.votersIds = hasMinSize(voterIds, 1, "votesIds");

        this.title = hasMaxText(title, 100, "title");
        this.description = hasMaxText(description, 4096, "description");

        this.criteria = hasMinSize(criteria, 2, "criteria");
        this.alternatives = hasMinSize(alternatives, 2, "alternatives");
    }
}
