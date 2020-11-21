package controller;

import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Habib, on 19/11/2020
 */
@RestController
public class RequestRequestExceptionHandlingController {

    @GetMapping("/request")
    public String firstRequest() {
        User user = new User();
        user.setId(1L);
        user.setName("Habib");
        if (user.getId().equals(1L)) {
            throw new IllegalStateException("oops this user is invalid");
        }
        return "this method is first request";
    }

}
