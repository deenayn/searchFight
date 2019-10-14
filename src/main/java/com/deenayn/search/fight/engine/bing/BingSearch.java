package com.deenayn.search.fight.engine.bing;

import com.deenayn.search.fight.config.ApplicationConfig;
import com.deenayn.search.fight.engine.SearchEngine;
import com.deenayn.search.fight.engine.bing.request.BingRequest;
import com.deenayn.search.fight.engine.bing.response.BingResponse;
import com.deenayn.search.fight.engine.bing.response.BingResponseBody;
import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;
import com.deenayn.search.fight.service.http.sender.HttpSender;
import com.deenayn.search.fight.service.http.sender.entity.HttpRequest;
import com.deenayn.search.fight.service.http.sender.entity.HttpResult;
import com.deenayn.search.fight.service.http.sender.entity.enums.HttpMethodType;

public class BingSearch extends SearchEngine<BingRequest, BingResponse> {

    private HttpSender sender;

    public BingSearch(HttpSender sender) {
        super(SearchEngineType.BING);
        this.sender = sender;
    }

    public BingResponse query(BingRequest request) throws Exception {
        HttpRequest httpRequest = new HttpRequest.Builder(ApplicationConfig.getInstance().getBingHost())
                .setType(HttpMethodType.GET)
                .setParams(request.getParams().toMap())
                .setHeaders(request.getHeaders().toMap())
                .build();

        HttpResult result = sender.execute(httpRequest);
        return new BingResponse(new BingResponseBody(result.getBody()), result.getHeaders());
    }
}
