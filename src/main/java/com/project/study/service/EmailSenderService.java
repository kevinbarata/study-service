package com.project.study.service;

import com.project.study.dto.EmailDetails;

// Interface
public interface EmailSenderService {

    int sendEmail(EmailDetails emailDetails);

}
