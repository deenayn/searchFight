package com.deenayn.search.fight.engine.google.request.enums;

public enum GoogleRequestParamsEnum {

    CX("cx"),
    KEY("key"),
    Q("q");

    private String name;

    GoogleRequestParamsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
