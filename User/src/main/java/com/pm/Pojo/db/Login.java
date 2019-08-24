package com.pm.Pojo.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Login {
    private String email_address;

    @JsonProperty("Password")
    private String Password;

}
