package com.stream.apitest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testControll {

    @GetMapping("/testController")
    public void getController(@RequestParam(value = "type",required = false) Integer type) {
        Integer t = type;
        System.out.println(t);
    }
}
