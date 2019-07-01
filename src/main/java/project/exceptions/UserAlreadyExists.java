package project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User Already Exists")
public class UserAlreadyExists extends RuntimeException {

    private String login;

    public UserAlreadyExists(String login){
        this.login = login;
    }
}
