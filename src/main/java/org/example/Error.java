package org.example;

public class Error {

    public Error(String path, String message) {
        this.path = path;
        this.message = message;
    }

    private String path;

    private String message;

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }
}
