package com.deenayn.search.fight.engine.bing.request;

import com.deenayn.search.fight.engine.bing.request.enums.BingRequestFieldsEnum;

import java.util.HashMap;
import java.util.Map;

public class BingRequestParams {

    private final String query;

    public BingRequestParams(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put(BingRequestFieldsEnum.Query.getName(), query);
        return map;
    }
}
