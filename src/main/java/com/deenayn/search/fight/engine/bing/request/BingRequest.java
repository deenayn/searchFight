package com.deenayn.search.fight.engine.bing.request;

import com.deenayn.search.fight.engine.entity.SearchEngineRequest;

public class BingRequest extends SearchEngineRequest<BingRequestParams, BingRequestHeaders> {

    public BingRequest(BingRequestHeaders headers, BingRequestParams params) {
        super(params, headers);
    }

    @Override
    public String getQuery() {
        return getParams().getQuery();
    }
}
