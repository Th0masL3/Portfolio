package com.lecoingameover.belecoingameover.CommentSubdomain.businesslayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.Comment;
import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.CommentIdentifier;
import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.CommentRepository;
import com.lecoingameover.belecoingameover.CommentSubdomain.datamapperlayer.CommentRequestMapper;
import com.lecoingameover.belecoingameover.CommentSubdomain.datamapperlayer.CommentResponseMapper;
import com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer.CommentRequestModel;
import com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer.CommentResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;
    private final CommentResponseMapper commentResponseMapper;
    private final CommentRequestMapper commentRequestMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentResponseMapper commentResponseMapper, CommentRequestMapper commentRequestMapper) {
        this.commentRepository = commentRepository;
        this.commentResponseMapper = commentResponseMapper;
        this.commentRequestMapper = commentRequestMapper;
    }

    @Override
    public List<CommentResponseModel> getAllComments() {
        List <Comment> commentList = commentRepository.findAll();
        return commentResponseMapper.entityToResponseModelList(commentList);
    }

    @Override
    public void deleteCommentByCommentId(String commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + commentId));
        commentRepository.delete(comment);
    }

    @Override
    public void approveCommentByCommentId(String commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + commentId));
        comment.setApproved(true);
        commentRepository.save(comment);
    }

    @Override
    public CommentResponseModel addComment(CommentRequestModel commentRequestModel) {
        Comment comment = commentRequestMapper.requestModelToEntity(commentRequestModel, new CommentIdentifier());
        Comment savedComment = commentRepository.save(comment);
        return commentResponseMapper.entityToResponseModel(savedComment);


    }


}
