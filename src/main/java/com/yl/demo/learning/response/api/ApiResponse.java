package com.yl.demo.learning.response.api;


import com.yl.demo.learning.utils.DateUtil;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse<T> {

    private String timestamp;
    private String path;
    private int code;
    private String codeValue;
    private String error;
    private String message;
    private T data;

    public ApiResponse(String timestamp, int code, String codeValue, String path, String error, String message, T data) {
        this.timestamp = timestamp;
        this.code = code;
        this.codeValue = codeValue;
        this.path = path;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(T data, HttpStatus httpStatus, String path) {
        this(DateUtil.now().toString(), httpStatus.value(), httpStatus.getReasonPhrase(), path, "", "", data);
    }

    public ApiResponse(T data, HttpStatus httpStatus) {
        this(DateUtil.now().toString(), httpStatus.value(), httpStatus.getReasonPhrase(), "", "", "", data);
    }

    public ApiResponse(T data, HttpStatus httpStatus, String path, String error, String message) {
        this(DateUtil.now().toString(), httpStatus.value(), httpStatus.getReasonPhrase(), path, error, message, data);
    }

    public ApiResponse(HttpStatus httpStatus, String error, String message) {
        this(DateUtil.now().toString(), httpStatus.value(), httpStatus.getReasonPhrase(), "", error, message, null);
    }

}
