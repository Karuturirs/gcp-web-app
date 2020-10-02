package com.karuturirs.gcp.webapp.pojo;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.HashMap;
import java.util.Map;

@JsonRootName(value = "Keys")
public class Keys {

    Map<String, String> key;

    public Map<String, String> getKey() {
        return key;
    }

    public void setKey(Map<String, String> key) {
        this.key = key;
    }

    public Map<String, String> addKey(String key, String value){
        if(this.key == null) {
            this.key = new HashMap();
        }
        this.key.put(key, value);
        return this.key;
    }
}
