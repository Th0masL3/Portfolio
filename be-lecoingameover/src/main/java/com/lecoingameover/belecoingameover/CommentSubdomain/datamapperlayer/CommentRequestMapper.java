package com.lecoingameover.belecoingameover.CommentSubdomain.datamapperlayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.Comment;
import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.CommentIdentifier;
import com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer.CommentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CommentRequestMapper {
    @Mappings({
        @Mapping(target = "commentId", ignore = true),
    })
    Comment requestModelToEntity(CommentRequestModel commentRequestModel, CommentIdentifier commentIdentifier);
}
