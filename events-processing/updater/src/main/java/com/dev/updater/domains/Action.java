package com.dev.updater.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action implements Serializable {

    private String postId;
    private long likeCount;
    private long unlikeCount;

    public Action(long likeCount, long unlikeCount) {
        this.likeCount = likeCount;
        this.unlikeCount = unlikeCount;
    }
}
