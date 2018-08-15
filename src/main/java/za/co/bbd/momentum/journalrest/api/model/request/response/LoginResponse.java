package za.co.bbd.momentum.journalrest.api.model.request.response;

import za.co.bbd.momentum.journalrest.dto.UserDTO;

public class LoginResponse {

    private UserDTO user;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
