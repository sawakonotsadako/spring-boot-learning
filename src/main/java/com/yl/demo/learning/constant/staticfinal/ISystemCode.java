package com.yl.demo.learning.constant.staticfinal;


public class ISystemCode {
    // USER CONTROLLER
    // REGISTER
    public static final String REGISTER_400 = "REGISTER_400";
    public static final String REGISTER_USER_EXIST = "REGISTER_409";

    // LOGIN
    public static final String LOGIN_400 = "LOGIN_400";
    public static final String LOGIN_USER_NOT_EXIST = "LOGIN_404";
    public static final String LOGIN_USER_PASSWORD_NOT_CORRECT = "LOGIN_USER_PASSWORD_NOT_CORRECT";
    public static final String LOGIN_USER_HAS_LOG_IN = "LOGIN_409";
    public static final String LOGIN_USER_BLOCKED = "LOGIN_USER_BLOCKED";
    public static final String LOGIN_USER_SUSPEND = "LOGIN_USER_SUSPEND";
    public static final String LOGIN_USER_EXPIRED = "LOGIN_USER_EXPIRED";
    public static final String LOGIN_USER_REGISTERED_NOT_ACTIVATED = "LOGIN_USER_REGISTERED_NOT_ACTIVATED";

    // LOGOUT
    public static final String LOGOUT_400 = "LOGOUT_400";
    public static final String LOGOUT_USER_NOT_EXIST = "LOGOUT_404";
    public static final String LOGOUT_USER_HAS_LOG_OUT = "LOGOUT_409";
    public static final String LOGOUT_USER_BLOCKED = "LOGOUT_USER_BLOCKED";
    public static final String LOGOUT_USER_SUSPEND = "LOGOUT_USER_SUSPEND";
    public static final String LOGOUT_USER_EXPIRED = "LOGOUT_USER_EXPIRED";
    public static final String LOGOUT_USER_REGISTERED_NOT_ACTIVATED = "LOGOUT_USER_REGISTERED_NOT_ACTIVATED";

    // ACTIVATE
    public static final String ACTIVATE_400 = "ACTIVATE_400";
    public static final String ACTIVATE_USER_NOT_EXIST = "ACTIVATE_404";
    public static final String ACTIVATE_USER_BLOCKED = "ACTIVE_USER_BLOCKED";
    public static final String ACTIVATE_USER_SUSPEND = "ACTIVE_USER_SUSPEND";
    public static final String ACTIVATE_USER_EXPIRED = "ACTIVE_USER_EXPIRED";
    public static final String ACTIVATE_USER_ALREADY_ACTIVATED = "ACTIVE_USER_ALREADY_ACTIVATED";

    // GET USER
    public static final String GET_USER_400 = "GET_USER_400";
    public static final String GET_USER_NOT_EXIST = "GET_USER_404";

    // UPDATE USER
    public static final String UPDATE_USER_400 = "UPDATE_USER_400";
    public static final String UPDATE_USER_NOT_EXIST = "UPDATE_USER_404";

    // DELETE USER
    public static final String DELETE_USER_400 = "DELETE_USER_400";
    public static final String DELETE_USER_NOT_EXIST = "DELETE_USER_404";

    // LOG CONTROLLER
    // GET AUDIT LOGS
    public static final String GET_AUDIT_LOGS_400 = "GET_AUDIT_LOGS_400";

}
