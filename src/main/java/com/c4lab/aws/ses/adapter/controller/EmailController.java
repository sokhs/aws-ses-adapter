package com.c4lab.aws.ses.adapter.controller;

import com.c4lab.aws.ses.adapter.response.ApiResponse;
import com.c4lab.aws.ses.adapter.response.CustomSendEmailResponse;
import com.c4lab.aws.ses.adapter.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sesv2.model.SendEmailRequest;
import software.amazon.awssdk.services.sesv2.model.SendEmailResponse;
import software.amazon.awssdk.services.sesv2.transform.SendEmailRequestMarshaller;

@RestController
@AllArgsConstructor
@RequestMapping("/api/send-email")
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/welcome")
    public ResponseEntity<ApiResponse<CustomSendEmailResponse>> sendWelcomeEmail() {
        SendEmailResponse sendEmailResponse = emailService.sendWelcomeEmail();
        CustomSendEmailResponse customSendEmailResponse = new CustomSendEmailResponse(sendEmailResponse.messageId());
        return ResponseEntity.ok(ApiResponse.success(customSendEmailResponse));
    }

    @GetMapping("/verification-code")
    public ResponseEntity<ApiResponse<CustomSendEmailResponse>> sendVerificationCodeEmail() {
        SendEmailResponse sendEmailResponse = emailService.sendVerificationCodeEmail();
        CustomSendEmailResponse customSendEmailResponse = new CustomSendEmailResponse(sendEmailResponse.messageId());
        return ResponseEntity.ok().body(ApiResponse.success(customSendEmailResponse));
    }

    @GetMapping("/password-reset")
    public ResponseEntity<ApiResponse<CustomSendEmailResponse>> sendPasswordReset() {
        SendEmailResponse sendEmailResponse = emailService.sendPasswordResetEmail();
        CustomSendEmailResponse customSendEmailResponse = new CustomSendEmailResponse(sendEmailResponse.messageId());
        return ResponseEntity.ok().body(ApiResponse.success(customSendEmailResponse));
    }

    @GetMapping("/system-error")
    public ResponseEntity<ApiResponse<CustomSendEmailResponse>> sendSystemErrorEmail() {
        SendEmailResponse sendEmailResponse = emailService.sendSystemError();
        CustomSendEmailResponse customSendEmailResponse = new CustomSendEmailResponse(sendEmailResponse.messageId());
        return ResponseEntity.ok().body(ApiResponse.success(customSendEmailResponse));
    }

}
