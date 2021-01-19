package com.app.Task.security;

public class SecurityConstants {
    public static final int EXPIRATION_TIME = 864_00_000;

    public static final String SECRET = "TaskApplication";

    public static final String HEADER_STRING = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer";

    public static final String SIGN_UP_URL = "/users/sign-up";
}
