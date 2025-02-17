package com.lecoingameover.belecoingameover.CommentSubdomain.datamapperlayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.Comment;
import com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer.CommentResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentResponseMapper {
    @Mapping(source = "commentId", target = "commentId")
    CommentResponseModel entityToResponseModel(Comment comment);

    List<CommentResponseModel> entityToResponseModelList(List<Comment> commentList);

}
