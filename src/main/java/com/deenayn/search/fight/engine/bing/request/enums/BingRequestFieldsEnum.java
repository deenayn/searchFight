package com.deenayn.search.fight.engine.bing.request.enums;

public enum BingRequestFieldsEnum {

    Key("Ocp-Apim-Subscription-Key"),
    Query("q");

    private String name;

    BingRequestFieldsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
