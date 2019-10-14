package com.deenayn.search.fight.service.http.sender.entity;

import java.util.List;
import java.util.Map;

public class HttpResult {

    private final String body;
    private final Map<String, List<String>> headers;

    public HttpResult(String body, Map<String, List<String>> headers) {
        this.body = body;
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }
}
