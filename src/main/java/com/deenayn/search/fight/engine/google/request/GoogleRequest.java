package com.deenayn.search.fight.engine.google.request;

import com.deenayn.search.fight.engine.entity.SearchEngineRequest;

public class GoogleRequest extends SearchEngineRequest<GoogleRequestParams, GoogleRequestHeaders> {

    public GoogleRequest(GoogleRequestParams params) {
        super(params, null);
    }

    @Override
    public String getQuery() {
        return getParams().getQuery();
    }
}
