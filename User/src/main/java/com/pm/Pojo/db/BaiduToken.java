package com.pm.Pojo.db;

import lombok.Data;

@Data
public class BaiduToken {
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private  String scope;
    private String session_key;
    private String session_secret;
}
