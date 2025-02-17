package com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutMeRepository extends MongoRepository<AboutMe, String> {

}