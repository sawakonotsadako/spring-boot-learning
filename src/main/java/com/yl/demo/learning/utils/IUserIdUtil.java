package com.yl.demo.learning.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class IUserIdUtil {

    public static String getUUID() {

        log.info("IUserIdUtil getUUID:", UUID.randomUUID().toString().toLowerCase());
        return UUID.randomUUID().toString().toLowerCase();
    }

    public static String getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] uuidArr = new String[number];
        for (int i=0; i<number; i++) {
            uuidArr[i] = getUUID();
        }
        return uuidArr.toString().toLowerCase();
    }

}
