package com.deenayn.search.fight.engine.entity;

public abstract class SearchEngineRequest<T, V> {

    private final T params;
    private final V headers;

    public SearchEngineRequest(T params, V headers) {
        this.params = params;
        this.headers = headers;
    }

    public T getParams() {
        return params;
    }

    public V getHeaders() {
        return headers;
    }

    public abstract String getQuery();
}
