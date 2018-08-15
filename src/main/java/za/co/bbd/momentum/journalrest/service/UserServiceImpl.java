package za.co.bbd.momentum.journalrest.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.momentum.journalrest.api.model.request.LoginRequest;
import za.co.bbd.momentum.journalrest.api.model.request.RegistrationRequest;
import za.co.bbd.momentum.journalrest.dto.UserDTO;
import za.co.bbd.momentum.journalrest.entity.User;
import za.co.bbd.momentum.journalrest.repo.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void register(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setCreatedOn(LocalDateTime.now());
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserDTO login(LoginRequest loginRequest) {
        User userByEmail = userRepository.getUserByEmail(loginRequest.getEmail());
	
	if(userByEmail == null) {
		return null;
	}

        if(userByEmail.getPassword().equals(loginRequest.getPassword())) {
            return mapper.map(userByEmail, UserDTO.class);
        }

        return null;
    }
}
