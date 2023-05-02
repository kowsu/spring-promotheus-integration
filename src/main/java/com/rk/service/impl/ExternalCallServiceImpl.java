package com.rk.service.impl;

import com.rk.service.IExternalCallService;
import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Service;

@Service
public class ExternalCallServiceImpl implements IExternalCallService {

    @Timed(value = "external.time.taken", description = "External Service Call Time Taken")
    @Override
    public String call() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "External Service Call Completed";
    }
}
