package com.dev.updater.kafka;

import com.dev.updater.domains.Event;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Message implements Serializable {
    private String transactionCode;
}
