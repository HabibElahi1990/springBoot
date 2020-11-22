package controller;

import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Habib, on 19/11/2020
 */
@RestController
public class RequestRequestInterceptorController {

    @GetMapping("/request")
    public String firstRequest() {
        User user = new User(1L, "Habib");
        return user.toString();
    }

}
