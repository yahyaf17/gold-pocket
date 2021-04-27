package com.enigma.pocket.wrapper;

import java.time.LocalDateTime;

public class WrapperMessage<T> {

    private Integer responseCode;
    private String description;
    private LocalDateTime timestamp;
    private T Data;

    public WrapperMessage(Integer responseCode, String description, T data) {
        this.responseCode = responseCode;
        this.description = description;
        Data = data;
    }

    public static <T> WrapperMessage<T> commonResponse(Integer code, T data) {
        return new WrapperMessage<>(code, "SUCCES", data);
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}

