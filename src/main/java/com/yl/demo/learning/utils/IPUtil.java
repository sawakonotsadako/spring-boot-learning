package com.yl.demo.learning.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class IPUtil {
    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = "";
        ipAddress = request.getHeader("x-forwarded-for");

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
            //log.info("into proxy");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress =  request.getHeader("WL-Proxy-Client-IP");
            //log.info("into WL proxy");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            //log.info("into remote");
        }
        //log.info("ipAddress:"+ipAddress);
        return ipAddress;
    }
}
