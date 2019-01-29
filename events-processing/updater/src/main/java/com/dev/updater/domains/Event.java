package com.dev.updater.domains;

import com.dev.updater.kafka.Message;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event extends Message {

    private String userId;
    private String postId;
    private String actionType; // like or unlike
}
