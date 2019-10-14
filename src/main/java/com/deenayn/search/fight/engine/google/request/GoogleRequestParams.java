package com.deenayn.search.fight.engine.google.request;

import com.deenayn.search.fight.engine.google.request.enums.GoogleRequestParamsEnum;

import java.util.HashMap;
import java.util.Map;

public class GoogleRequestParams {

    private final String query;
    private final String key;
    private final String cx;

    public GoogleRequestParams(String key, String cx, String q) {
        this.query = q;
        this.key = key;
        this.cx = cx;
    }

    public String getKey() {
        return key;
    }

    public String getCx() {
        return cx;
    }

    public String getQuery() {
        return query;
    }

    public Map<String, String> toMap() {
        Map<String, String> params = new HashMap<>();
        params.put(GoogleRequestParamsEnum.CX.getName(), cx);
        params.put(GoogleRequestParamsEnum.KEY.getName(), key);
        params.put(GoogleRequestParamsEnum.Q.getName(), query);

        return params;
    }
}
