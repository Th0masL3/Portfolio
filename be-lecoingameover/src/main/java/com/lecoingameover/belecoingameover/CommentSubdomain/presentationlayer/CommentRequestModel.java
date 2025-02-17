package com.lecoingameover.belecoingameover.CommentSubdomain.presentationlayer;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentRequestModel {
    private String name;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();
}
