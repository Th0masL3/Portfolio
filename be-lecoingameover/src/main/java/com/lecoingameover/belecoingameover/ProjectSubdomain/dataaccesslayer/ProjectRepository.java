package com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

}