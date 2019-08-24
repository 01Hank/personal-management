package com.pm.Pojo.db;

import lombok.Data;

@Data
public class Register {
    private String username;
    private String password;
    private String invitation_code;
    private String email_address;
    private String type;
}
