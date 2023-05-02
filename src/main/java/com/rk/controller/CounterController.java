package com.rk.controller;

import com.rk.service.IExternalCallService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {
    private final Counter counter = Counter.builder("example_requests_total")
            .description("Total number of example requests")
            .register(Metrics.globalRegistry);

    @Autowired
    private IExternalCallService externalCallService;

    @GetMapping("/counter")
    public String example() {
        counter.increment();
        return "Example response";
    }

    @GetMapping("/external")
    public String makeExternalCall() {
        return externalCallService.call();
    }
}
