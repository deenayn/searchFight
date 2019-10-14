package com.deenayn.search.fight.engine.google.response;

import com.deenayn.search.fight.engine.entity.SearchEngineResponse;

import java.util.List;
import java.util.Map;

public class GoogleResponse extends SearchEngineResponse<GoogleResponseBody> {

    public GoogleResponse(GoogleResponseBody body, Map<String, List<String>> headers) {
        super(body, headers);
    }

    @Override
    public Long getTotal() {
        return getBody().getTotalResults();
    }
}
