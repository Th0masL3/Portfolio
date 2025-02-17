package com.lecoingameover.belecoingameover.CommentSubdomain.businesslayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer.CommentRequestModel;
import com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer.CommentResponseModel;

import java.util.List;

public interface CommentService {
    public List<CommentResponseModel> getAllComments();
    void deleteCommentByCommentId(String commentId);
    void approveCommentByCommentId(String commentId);
    public CommentResponseModel addComment(CommentRequestModel comment);
}
