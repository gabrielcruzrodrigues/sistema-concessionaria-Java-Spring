package com.example.sistema.exceptions;

import java.time.LocalDateTime;

public class StandardError {
    private LocalDateTime timeStamp;
    private Integer status;
    private String fieldError;
    private String path;

    public StandardError(LocalDateTime timeStamp, Integer status, String fieldError, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.fieldError = fieldError;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFieldError() {
        return fieldError;
    }

    public void setFieldError(String fieldError) {
        this.fieldError = fieldError;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
