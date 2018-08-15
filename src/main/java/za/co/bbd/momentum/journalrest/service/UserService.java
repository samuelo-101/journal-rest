package za.co.bbd.momentum.journalrest.service;

import za.co.bbd.momentum.journalrest.api.model.request.LoginRequest;
import za.co.bbd.momentum.journalrest.api.model.request.RegistrationRequest;
import za.co.bbd.momentum.journalrest.dto.UserDTO;

public interface UserService {

    void register(RegistrationRequest registrationRequest);
    UserDTO login(LoginRequest loginRequest);
}
