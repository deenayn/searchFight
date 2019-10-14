package com.deenayn.search.fight.engine;

import com.deenayn.search.fight.engine.entity.SearchEngineRequest;
import com.deenayn.search.fight.engine.entity.SearchEngineResponse;
import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;

public abstract class SearchEngine<K extends SearchEngineRequest, T extends SearchEngineResponse> {

    private final SearchEngineType type;

    protected SearchEngine(SearchEngineType type) {
        this.type = type;
    }

    public abstract T query(K request) throws Exception;

    public SearchEngineType getType() {
        return type;
    }
}
