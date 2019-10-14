package com.deenayn.search.fight.engine.entity;

import java.util.List;
import java.util.Map;

public abstract class SearchEngineResponse<T> {

    private final Map<String, List<String>> headers;
    private final T body;

    public SearchEngineResponse(T body, Map<String, List<String>> headers) {
        this.headers = headers;
        this.body = body;
    }

    public abstract Long getTotal();

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public T getBody() {
        return body;
    }
}
