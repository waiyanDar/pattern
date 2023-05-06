package com.example.counterservice.controller;

import com.example.counterservice.ds.CounterServiceRequest;
import com.example.counterservice.ds.CounterServiceResponse;
import com.example.counterservice.service.MutableCounterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counter/stateFull")
public class StateFullController {

    private final MutableCounterService service;

    public StateFullController(MutableCounterService service) {
        this.service = service;
    }

    @PostMapping("/countUp")
    public CounterServiceResponse response(){
        service.countUp();
        return new CounterServiceResponse(service.getNumber());
    }
}
