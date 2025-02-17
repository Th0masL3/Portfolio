package com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CommentIdentifier
{
    private final String commentId;
    public CommentIdentifier(){ this.commentId = UUID.randomUUID().toString();
    }
}
