package com.example.mysql.model;

import com.example.mysql.constants.ErrorMessageConstants;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Pattern(regexp = "^\\d{10}$",message = ErrorMessageConstants.MOBILE_ERROR_MESSAGE)
    private String mobileNo;
    @Email(message= ErrorMessageConstants.EMAIL_ERROR_MESSAGE)
    private String emailId;
    private String name;
    private boolean active = true;
}
