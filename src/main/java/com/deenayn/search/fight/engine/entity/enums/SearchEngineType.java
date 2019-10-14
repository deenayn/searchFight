package com.deenayn.search.fight.engine.entity.enums;

public enum SearchEngineType {

    GOOGLE("Google"),
    BING("Bing");

    private String name;

    SearchEngineType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
