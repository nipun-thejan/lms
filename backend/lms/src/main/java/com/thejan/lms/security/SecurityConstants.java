package com.thejan.lms.security;

public class SecurityConstants {
    public static final String SECRET_KEY = "3777217A25432646294A404E635266556A586E3272357538782F413F4428472D"; //Your secret should always be strong (uppercase, lowercase, numbers, symbols) so that nobody can potentially decode the signature.
    public static final int TOKEN_EXPIRATION = 7200000; // 7200000 milliseconds = 7200 seconds = 2 hours.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token 
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String REGISTER_PATH = "api/v1/auth/register"; // Public path that clients can use to register.
    public static final String AUTH_PATH = "api/v1/auth";
    public static final String BASIC = "Basic";
}