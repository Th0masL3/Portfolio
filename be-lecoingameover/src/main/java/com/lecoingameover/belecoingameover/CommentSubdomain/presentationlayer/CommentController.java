package com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer;

import com.lecoingameover.belecoingameover.CommentSubdomain.businesslayer.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
private CommentService commentService;
public CommentController(CommentService commentService) {
    this.commentService = commentService;
}

    @GetMapping
    public ResponseEntity<List<CommentResponseModel>> getAllComments(HttpEntity<Object> httpEntity) {
        List<CommentResponseModel> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentResponseModel> deleteComment(@PathVariable String commentId) {
        commentService.deleteCommentByCommentId(commentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{commentId}/approve")
    public ResponseEntity<Void> approveCommentByCommentId(@PathVariable String commentId) {
        log.info("Approving comment with ID: {}", commentId);
        commentService.approveCommentByCommentId(commentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<CommentResponseModel> addComment(@RequestBody CommentRequestModel commentRequestModel) {
        commentService.addComment(commentRequestModel);
        return ResponseEntity.ok().build();
    }
}
