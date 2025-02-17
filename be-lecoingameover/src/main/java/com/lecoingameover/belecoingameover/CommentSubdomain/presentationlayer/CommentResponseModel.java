package com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseModel {
    private String commentId;
    private String name;
    private String message;
    private LocalDateTime timestamp;
    private boolean approved = false;
}
