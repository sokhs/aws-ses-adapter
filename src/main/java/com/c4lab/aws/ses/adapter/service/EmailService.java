package com.c4lab.aws.ses.adapter.service;

import com.c4lab.aws.ses.adapter.common.util.EmailContentUtil;
import com.c4lab.aws.ses.adapter.common.util.EmailSubjectUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sesv2.SesV2Client;
import software.amazon.awssdk.services.sesv2.model.*;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class EmailService {

    private final SesV2Client sesClient;

    private final String defaultCharset = "UTF-8";

    private final String to = "hengsok.hs9927@gmail.com";

    public SendEmailResponse sendEmailByHtmlContent(
            String subject
    ) {
        Destination destination = Destination.builder().toAddresses(to).build();
        Content subjectContent = Content.builder().data(subject).charset(defaultCharset).build();
        Content emailContent = EmailContentUtil.welcomeContent("Heng Sok", "heng.sok");
        return sendHtmlEmail(destination, subjectContent, emailContent);
    }

    public SendEmailResponse sendSystemError() {
        Destination destination = Destination.builder().toAddresses(to).build();
        Content emailSubject = this.makeSubjectContentUtil(EmailSubjectUtil.SYSTEM_ERROR_SUBJECT);
        Content emailContent = Content.builder().data("☢ System Error").build();
        return sendPlainTextEmail(destination, emailSubject, emailContent);
    }

    public SendEmailResponse sendWelcomeEmail() {
        Destination destination = Destination.builder().toAddresses(to).build();
        Content emailSubject = this.makeSubjectContentUtil(EmailSubjectUtil.WELCOME_SUBJECT);
        Content emailContent = EmailContentUtil.welcomeContent("Heng Sok", "sokhs");
        return sendHtmlEmail(destination, emailSubject, emailContent);
    }

    public SendEmailResponse sendVerificationCodeEmail() {
        Destination destination = Destination.builder().toAddresses(to).build();
        Content emailSubject = this.makeSubjectContentUtil(EmailSubjectUtil.VERIFICATION_CODE_SUBJECT.formatted("336699"));
        Content emailContent = EmailContentUtil.verificationCodeContent("336699", "Heng Sok", LocalDateTime.now().toString());
        return sendHtmlEmail(destination, emailSubject, emailContent);
    }

    public SendEmailResponse sendPasswordResetEmail() {
        Destination destination = Destination.builder().toAddresses(to).build();
        Content emailSubject = this.makeSubjectContentUtil(EmailSubjectUtil.PASSWORD_RESET_SUBJECT);
        Content emailContent = EmailContentUtil.passwordResetContent("Heng Sok", "sokhs", "REQ123456789");
        return sendHtmlEmail(destination, emailSubject, emailContent);
    }



    private SendEmailResponse sendPlainTextEmail(Destination destination, Content content, Content message) {
        Body body = Body.builder().text(message).build();
        return this.sendEmail(destination, content, body);
    }

    private SendEmailResponse sendHtmlEmail(Destination destination, Content subject, Content message) {
        Body body = Body.builder().html(message).build();
        return this.sendEmail(destination, subject, body);
    }

    private SendEmailResponse sendEmail(Destination destination, Content emailSubject, Body emailContent) {
        Message emailMessage = Message.builder().subject(emailSubject).body(emailContent).build();
        EmailContent content = EmailContent.builder().simple(emailMessage).build();

        String from = "hengsokhs07@gmail.com";
        SendEmailRequest request = SendEmailRequest
                .builder()
                .fromEmailAddress(from)
                .destination(destination)
                .content(content)
                .build();

        return sesClient.sendEmail(request);
    }

    private Content makeSubjectContentUtil(String content) {
        return Content.builder().data(content).charset(defaultCharset).build();
    }

}
