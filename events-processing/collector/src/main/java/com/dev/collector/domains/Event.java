package com.dev.collector.domains;

import com.dev.collector.kafka.Message;
import lombok.*;

import java.io.Serializable;

@Data
public class Event extends Message {

    private String userId;
    private String postId;
    private String actionType; // like or unlike
}
