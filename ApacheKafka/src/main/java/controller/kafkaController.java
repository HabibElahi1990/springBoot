package controller;

import model.User;
import org.springframework.web.bind.annotation.*;
import service.ProducerService;

/**
 * Created by Habib, on 17/11/2020
 */
@RestController
@RequestMapping("/kafka")
public class kafkaController {

    private final ProducerService producerService;

    public kafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestParam String message){
        producerService.sendMessage(message);
    }

    @PostMapping("/sendUserInfo")
    public void sendUserInfo(@RequestBody User user){
        producerService.sendMessage(user);
    }
}
