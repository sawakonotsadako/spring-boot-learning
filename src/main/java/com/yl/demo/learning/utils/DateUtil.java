package com.yl.demo.learning.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static Date now() {
        return Date.from(
                LocalDateTime.now()
                        .atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}
