package com.zte.sunquan.demo.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @RequestMapping("/sunquan")
    String home() {
        return "Hello World!";
    }
}
