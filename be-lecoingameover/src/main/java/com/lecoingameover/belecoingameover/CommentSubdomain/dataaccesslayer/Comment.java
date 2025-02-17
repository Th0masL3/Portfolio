package com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "comments")
public class Comment {
    @Id
    private String commentId;

    @Indexed(unique = true)
    private CommentIdentifier commentIdentifier;
    private String id;
    private String name;
    private String message;
    private LocalDateTime timestamp;
    private boolean approved = false;


}