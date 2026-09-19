package com.c4lab.aws.ses.adapter.common.util;

import lombok.NoArgsConstructor;
import software.amazon.awssdk.services.sesv2.model.Content;

@NoArgsConstructor
public class EmailContentUtil {

    public static Content welcomeContent(String fullName, String userName) {
        String html = """
                Dear %s,
                
                Welcome to our application!
                
                Your account has been created successfully.
                
                Username: %s
                Account Status: Active
                
                Best Regards,
                HR Department
                """.formatted(fullName, userName);
        return Content.builder().data(html).charset("UTF-8").build();
    }

    public static Content verificationCodeContent(String verificationCode, String fullName, String reqDate) {
        String html = """
                Dear %s,
                
                Your verification code is:
                
                %s
                
                This code will expire in 5 minutes.
                
                Request Time: %s
                
                For security reason, please do not share this code with anyone.
                
                If you did not request this verification code, you can safely ignore this email.
                
                Regards,
                Security Team
                """.formatted(fullName, verificationCode, reqDate);
        return Content.builder().data(html).charset("UTF-8").build();
    }

    public static Content passwordResetContent(String fullName, String userName, String reqId) {
        String html = """
                Dear %s,
                
                We received a request to reset the password for your account.
                
                Username: %s
                Request ID: %s
                
                Please use the password reset link provided by the application to create a new password.
                
                The reset link will expire in 30 minutes.
                
                If you did not request a password reset, please ignore this email. Your existing password will remain unchanged.
                
                Best regards,
                Security Team
                """.formatted(fullName, userName, reqId);
        return Content.builder().data(html).build();
    }

}
