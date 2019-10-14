package com.deenayn.search.fight.engine.bing.response;

import com.deenayn.search.fight.engine.bing.response.enums.BingResponseParamsEnum;
import utils.JsonUtils;

public class BingResponseBody {

    private final long totalResults;

    public BingResponseBody(String json) {
        Long totalResults = JsonUtils.getLongValue(BingResponseParamsEnum.TOTAL_ESTIMATED_MATCHES.getName(), json);
        this.totalResults = totalResults != null ? totalResults : 0L;
    }

    public long getTotalResults() {
        return totalResults;
    }
}
