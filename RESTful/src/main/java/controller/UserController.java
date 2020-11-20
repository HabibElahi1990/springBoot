package controller;

import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

/**
 * Created by Habib, on 20/11/2020
 */
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //It reads a User.
    @GetMapping("/getUser")
    public ResponseEntity getUser(@RequestParam Long userId) {
        String user = userService.getUser(userId);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    //It creates a new User.
    @PostMapping("/saveUser")
    public ResponseEntity saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    //It updates an existing User
    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody User user) {
        User user1 = userService.updateUser(user);
        if (user1==null){
            return new ResponseEntity("user not found for updating", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user1.toString(), HttpStatus.OK);
    }

    //It deletes the User.
    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity getAllUser(){
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity(allUser, HttpStatus.OK);
    }

}
