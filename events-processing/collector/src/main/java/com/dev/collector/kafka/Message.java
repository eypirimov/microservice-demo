package com.dev.collector.kafka;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Message implements Serializable {
    private String transactionCode;
}
