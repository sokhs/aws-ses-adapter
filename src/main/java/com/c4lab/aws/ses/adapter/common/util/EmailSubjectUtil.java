package com.c4lab.aws.ses.adapter.common.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmailSubjectUtil {
    public static final String SYSTEM_ERROR_SUBJECT = "System Alert: Job Failed";
    public static final String WELCOME_SUBJECT = "Welcome to Our Application";
    public static final String VERIFICATION_CODE_SUBJECT = "Verification Code: %s";
    public static final String PASSWORD_RESET_SUBJECT = "Password Reset Request";
}
