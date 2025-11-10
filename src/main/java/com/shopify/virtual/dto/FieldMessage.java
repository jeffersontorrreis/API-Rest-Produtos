package com.shopify.virtual.dto;

public class FieldMessage {
    private String fieldName;
    private String message;

public FieldMessage(String fieldName, String message) {
    this.fieldName = fieldName;
    this. message = message;
}

    public String getfieldName(){return fieldName; }
    public String getMessage() { return message; }
}

