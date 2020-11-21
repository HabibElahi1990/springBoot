package controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Habib, on 19/11/2020
 */
@RestController
public class RequestRestTemplate {

    @GetMapping("/firstRequest")
    public String firstRequest() {
        return "this method is first request";
    }

    @GetMapping("/clientRequest")
    public String clientRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8091/serverRequest";
        User user = User.builder()
                .id(1L)
                .userName("HabibElahi")
                .password("123456")
                .activeFlag(true)
                .build();
        MultiValueMap<String,String> prop=new LinkedMultiValueMap<>();
        prop.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
        HttpHeaders headers=new HttpHeaders(prop);
        HttpEntity<User> request = new HttpEntity<>(user,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,request, String.class);

        return responseEntity.getBody();
    }

    @PostMapping("/serverRequest")
    public String serverRequest(@RequestBody User user) {
        return user.toString();
    }
}
