package com;

import lombok.Data;

import java.util.Collection;



public class EmailRequest {
    private String emailContent;
    private String tone;

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }
}
