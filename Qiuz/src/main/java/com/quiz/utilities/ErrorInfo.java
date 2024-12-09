package com.quiz.utilities;

public class ErrorInfo {
    private String message;
    private int statusCode;
    private String details;

    public ErrorInfo(String message, int statusCode, String details) {
        this.message = message;
        this.statusCode = statusCode;
        this.details = details;
    }
    public ErrorInfo() {
    	super();
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", details='" + details + '\'' +
                '}';
    }
}
