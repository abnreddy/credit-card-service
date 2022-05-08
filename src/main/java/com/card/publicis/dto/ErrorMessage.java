package com.card.publicis.dto;

import lombok.Data;

@Data
public class ErrorMessage {

    private int httpCode;

    private String httpMessage;

    private String message;

}
