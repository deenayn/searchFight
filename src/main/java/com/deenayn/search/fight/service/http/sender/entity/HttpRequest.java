package com.deenayn.search.fight.service.http.sender.entity;

import com.deenayn.search.fight.service.http.sender.entity.enums.HttpMethodType;

import java.util.Map;

public class HttpRequest {

    private final String url;
    private final HttpMethodType type;
    private final Map<String, String> headers;
    private final Map<String, String> params;

    private HttpRequest(String url, HttpMethodType type, Map<String, String> headers, Map<String, String> params) {
        this.url = url;
        this.type = type;
        this.headers = headers;
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethodType getType() {
        return type;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public static class Builder {
        private Map<String, String> headers;
        private Map<String, String> params;
        private String url;
        private HttpMethodType type;

        public Builder(String url) {
            this.url = url;
        }

        public Builder setHeaders(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder setParams(Map<String, String> params) {
            this.params = params;
            return this;
        }

        public Builder setType(HttpMethodType type) {
            this.type = type;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(url, type, headers, params);
        }
    }
}
