package com.example.mysql.model;

import lombok.Data;

@Data
public class MetaResponse {
    private String msg;
    private int statusCode;
    private boolean error;
}
