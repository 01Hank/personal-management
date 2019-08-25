package com.pm.Pojo.db;

import lombok.Data;

@Data
public class BaiduResults {
    private int err_no;
    private String corpus_no;
    private String err_msg;
    private String sn;
    private String[] result;
}
