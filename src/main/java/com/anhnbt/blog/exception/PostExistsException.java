package com.anhnbt.blog.exception;

public class PostExistsException extends Exception {
    public PostExistsException(String message) {
        super(message);
    }
}
