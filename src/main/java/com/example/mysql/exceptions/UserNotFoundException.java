package com.example.mysql.exceptions;


import com.example.mysql.constants.ErrorMessageConstants;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id){
        super(ErrorMessageConstants.USER_NOT_FOUND_ERROR_MESSAGE+id);
    }
}
