package com.counter.counter.service;

import com.counter.counter.model.Counter;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CounterService {

    private static Counter counter = new Counter();
    private static int num=1;
    private static HashMap<String , Integer> visitor = new HashMap<>();
    public Counter updateCounter(String user){
        if(visitor.containsKey(user)){
            visitor.put(user, visitor.get(user)+1);
            counter.setCount(visitor.get(user));
            counter.setName(user);
        }else{
            visitor.put(user, 1);
            counter.setCount(1);
            counter.setName(user);
        }
        return counter;
    }
}
