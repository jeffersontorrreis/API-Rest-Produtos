package com.shopify.virtual.dto;

import java.time.Instant;

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Integer status, Instant timestamp, String error, String path) {
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
