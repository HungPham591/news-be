package com.news.news.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
public class AccountRequest {
    @NotEmpty(message = "auth missing email")
    @Email(message = "email invalid")
    private String email;
    @NotEmpty(message = "auth missing password")
    private String password;
    private String matchingPassword;
}