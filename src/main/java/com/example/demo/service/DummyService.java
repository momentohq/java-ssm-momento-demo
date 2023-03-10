package com.example.demo.service;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughMultiCache;
import com.google.code.ssm.api.ReadThroughSingleCache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DummyService {
    private final AtomicLong counter = new AtomicLong();

    @ReadThroughSingleCache(expiration = 60, namespace = "default")
    public String callService(@ParameterValueKeyProvider String anything){
        return counter.incrementAndGet() + " " +  anything;
    }

    @ReadThroughMultiCache(expiration = 60, namespace = "default")
    public List<String> callServiceList(@ParameterValueKeyProvider List<String> anythings) {
        final List<String> list = new ArrayList<>();
        for (String anything : anythings) {
            list.add(counter.incrementAndGet() + "-" + anything);
        }
        return list;
    }
}
