package com.pm.Utils;

import java.util.UUID;

public class UUIDs {
    public  String  getUUID(){
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid).replace("-", "");
    }
}
