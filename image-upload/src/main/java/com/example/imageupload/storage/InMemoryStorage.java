package com.example.imageupload.storage;

import org.apache.commons.lang3.ArrayUtils;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class InMemoryStorage {

    private Map<String, Byte[]> store = new HashMap<>();

    public void store (String name, byte [] content){
        store.put(name, ArrayUtils.toObject(content));
    }

    public Set<String> getName(){
        return store.keySet();
    }

    public byte[] getByName(String name){
        return ArrayUtils.toPrimitive(store.get(name));
    }

}