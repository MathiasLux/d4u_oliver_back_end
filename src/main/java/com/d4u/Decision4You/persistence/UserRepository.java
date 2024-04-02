package com.d4u.Decision4You.persistence;

import com.d4u.Decision4You.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("{ 'id' : { $ne: ?0 } }")
    List<User> findAllExclude(String userId);
}
