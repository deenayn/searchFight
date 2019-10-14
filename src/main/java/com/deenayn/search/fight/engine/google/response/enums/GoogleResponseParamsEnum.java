package com.deenayn.search.fight.engine.google.response.enums;

/**
 * a path to fields in google response test.cases
 */
public enum GoogleResponseParamsEnum {

    TOTAL_RESULT("totalResults");

    private String name;

    GoogleResponseParamsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

