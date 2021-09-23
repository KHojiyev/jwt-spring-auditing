package uzdev.jwtspringauditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uzdev.jwtspringauditing.payload.ApiResponse;
import uzdev.jwtspringauditing.payload.UserDTO;
import uzdev.jwtspringauditing.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping()
    public HttpEntity<?> registerUser(@RequestBody UserDTO userDTO){
        ApiResponse apiResponse = authService.registerUser(userDTO);
        return ResponseEntity.status(apiResponse.isStatus() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).
                body(apiResponse.getObject());
    }





}
