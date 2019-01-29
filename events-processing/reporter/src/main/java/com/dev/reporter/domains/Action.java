package com.dev.reporter.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    private String postId;
    private long likeCount;
    private long unlikeCount;
}
