package com.counter.counter.controller;

import com.counter.counter.model.Counter;
import com.counter.counter.service.CounterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CounterController {

    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/counter/user/{user}")
    public Counter updateCounter(@PathVariable String user){
        return counterService.updateCounter(user);
    }
}
