package com.project.study.dto;

import lombok.Data;

@Data
public class EmailDetails {

    private String from;
    private String to;
    private String subject;
    private String message;
}