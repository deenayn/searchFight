package com.deenayn.search.fight.engine.google.response;

import com.deenayn.search.fight.engine.google.response.enums.GoogleResponseParamsEnum;
import utils.JsonUtils;

public class GoogleResponseBody {

    private long totalResults;

    public GoogleResponseBody(String json) {
        Long totalResults = JsonUtils.getLongValue(GoogleResponseParamsEnum.TOTAL_RESULT.getName(), json);
        this.totalResults = totalResults != null ? totalResults : 0L;
    }

    public long getTotalResults() {
        return totalResults;
    }
}
