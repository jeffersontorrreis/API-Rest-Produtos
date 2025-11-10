package com.shopify.virtual.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private List<FieldMessage> erros = new ArrayList<>();
    public ValidationError(Instant timestamp, Integer status, String error, String path){
        super(status, timestamp, error, path);
    }
    public List<FieldMessage> getErros() {
        return erros;
    }
    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
}

