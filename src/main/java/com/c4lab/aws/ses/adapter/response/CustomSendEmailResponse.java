package com.c4lab.aws.ses.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Setter
@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomSendEmailResponse {
    private String messageId;
}
