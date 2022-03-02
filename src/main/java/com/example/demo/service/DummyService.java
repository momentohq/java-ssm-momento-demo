package com.example.demo.service;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class DummyService {
    private final AtomicLong counter = new AtomicLong();

    @ReadThroughSingleCache(expiration = 60, namespace = "default")
    public String callService(@ParameterValueKeyProvider String anything){
        return counter.incrementAndGet() + " " +  anything;
    }
}
