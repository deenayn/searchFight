package com.deenayn.search.fight.engine.bing.response;

import com.deenayn.search.fight.engine.entity.SearchEngineResponse;

import java.util.List;
import java.util.Map;

public class BingResponse extends SearchEngineResponse<BingResponseBody> {

    public BingResponse(BingResponseBody body, Map<String, List<String>> headers) {
        super(body, headers);
    }

    @Override
    public Long getTotal() {
        return getBody().getTotalResults();
    }
}
