package com.codehelp.CodeHelp.ServiceImp;

import com.codehelp.CodeHelp.Services.UserService;
import com.codehelp.CodeHelp.dtos.SignupDTO;
import com.codehelp.CodeHelp.Model.User;
import com.codehelp.CodeHelp.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User register(SignupDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }
}
