package za.co.bbd.momentum.journalrest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.momentum.journalrest.api.model.request.LoginRequest;
import za.co.bbd.momentum.journalrest.api.model.request.RegistrationRequest;
import za.co.bbd.momentum.journalrest.api.model.request.response.LoginResponse;
import za.co.bbd.momentum.journalrest.dto.UserDTO;
import za.co.bbd.momentum.journalrest.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegistrationRequest registrationRequest) {
        userService.register(registrationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        UserDTO userDTO = userService.login(loginRequest);

	if(userDTO == null) {
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(userDTO);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
