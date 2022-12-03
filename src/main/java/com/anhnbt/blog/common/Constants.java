package com.anhnbt.blog.common;

public interface Constants {
    interface Roles {
        String ROLE_ADMIN = "ROLE_ADMIN";
        String ROLE_USER = "ROLE_USER";
    }

    interface Privileges {
        String READ_PRIVILEGE = "READ_PRIVILEGE";
        String WRITE_PRIVILEGE = "WRITE_PRIVILEGE";
        String DELETE_PRIVILEGE = "DELETE_PRIVILEGE";
    }

    String MESSAGE = "message";

    interface MESSAGE_TYPE {
        String DANGER = "danger";
        String SUCCESS = "success";
    }
}
