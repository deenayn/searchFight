package com.deenayn.search.fight.engine.bing.request;

import com.deenayn.search.fight.engine.bing.request.enums.BingRequestFieldsEnum;

import java.util.HashMap;
import java.util.Map;

public class BingRequestHeaders {

    private final String key;

    public BingRequestHeaders(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put(BingRequestFieldsEnum.Key.getName(), key);
        return map;
    }
}
