package com.example.soloproject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static final Pattern VALID_PASSWORD_REGEX_ALPHA_NUM
            = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{8,20}$"); // 8자리 ~ 20자리까지 가능

    public static final Pattern VALID_PHONE_REGEX_NUM
            = Pattern.compile("^[0-9]{11}$"); // 전화번호 정규식

    public static final Pattern VALID_ID_REGEX_ALPHA_NUM
            = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{6,15}$"); // 6자리 ~ 15자리까지 가능


    // 비밀번호 검사
    public static boolean validatePassword(String pwStr) {
        Matcher matcher = VALID_PASSWORD_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }

    // 전화번호 검사
    public static boolean validatePhone(String phoneStr) {
        Matcher matcher = VALID_PHONE_REGEX_NUM.matcher(phoneStr);
        return matcher.matches();
    }

    public static boolean validateID(String pwStr) {
        Matcher matcher = VALID_ID_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }

    protected static boolean agreements;
    protected static boolean check;
}
