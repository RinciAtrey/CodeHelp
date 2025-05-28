package com.codehelp.CodeHelp.Services;


import com.codehelp.CodeHelp.dtos.SignupDTO;
import com.codehelp.CodeHelp.Model.User;

public interface UserService {
    User register(SignupDTO signupDTO);
}
