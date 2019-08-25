package com.pm.Pojo.db;

import lombok.Data;

import java.util.Random;

@Data
public class BaiduMusic {
    private final String format = "pcm";
    private final int rate = 16000;
    private final int channel = 1;
    private String cuid;//机器唯一表示
    private String token;//获取的token
    private  String speech;//base64过后的文件
    private int len;//文件二进制长度
}
