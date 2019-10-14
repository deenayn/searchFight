package com.deenayn.search.fight.service.http.sender.entity.enums;

public enum HttpMethodType {

    GET("GET");

    private String name;

    HttpMethodType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
