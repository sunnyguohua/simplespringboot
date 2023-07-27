package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/hello", name = "返回Hello World")
    public String hello(@RequestParam(value = "name", required = false) String name) throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name" , name);
        map.put("time" , new Date().toString());

        String json = new ObjectMapper().writeValueAsString(map);
        System.out.println(json);
        return String.format("Hello %s! ", name == null ? "World" : name);
    }
}