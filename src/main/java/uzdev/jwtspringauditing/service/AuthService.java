package uzdev.jwtspringauditing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uzdev.jwtspringauditing.entity.User;
import uzdev.jwtspringauditing.entity.enums.RoleName;
import uzdev.jwtspringauditing.payload.ApiResponse;
import uzdev.jwtspringauditing.payload.UserDTO;
import uzdev.jwtspringauditing.repository.RoleRepository;
import uzdev.jwtspringauditing.repository.UserRepository;

import java.util.Collections;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public ApiResponse registerUser(UserDTO userDTO) {
        boolean exists = userRepository.existsByEmail(userDTO.getEmail());
        if (exists)
            return new ApiResponse(false,"email already exists",null);

        User  user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_USER)));
        user.setEmailCode(UUID.randomUUID().toString());

        userRepository.save(user);




        return null;
    }

    public  Boolean sendEmail(String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noReply@gmail.com");
        message.setTo(email);
        message.setSubject("mail header");
        message.setText("mail text");
        javaMailSender.send(message);
        return true;
    }


}
