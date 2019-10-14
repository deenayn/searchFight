package com.deenayn.search.fight.entity;

import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;

import java.util.HashMap;
import java.util.Map;

public class SearchResult {

    private final String query;
    private Map<SearchEngineType, Long> totalValuesMap = new HashMap<>();

    public SearchResult(String query) {
        this.query = query;
    }

    public SearchResult addTotalResult(SearchEngineType type, Long totalValue) {
        totalValuesMap.put(type, totalValue);
        return this;
    }

    public String getQuery() {
        return query;
    }

    public Map<SearchEngineType, Long> getTotalValuesMap() {
        return totalValuesMap;
    }
}
