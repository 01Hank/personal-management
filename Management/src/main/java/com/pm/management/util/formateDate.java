package com.pm.management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class formateDate {

    public Date formate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = sdf.parse(date);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
