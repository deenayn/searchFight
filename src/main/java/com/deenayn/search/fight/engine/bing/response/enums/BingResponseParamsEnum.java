package com.deenayn.search.fight.engine.bing.response.enums;

public enum BingResponseParamsEnum {

    TOTAL_ESTIMATED_MATCHES("totalEstimatedMatches");

    private String name;

    BingResponseParamsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
