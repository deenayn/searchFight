package com.deenayn.search.fight.engine.google;

import com.deenayn.search.fight.config.ApplicationConfig;
import com.deenayn.search.fight.engine.SearchEngine;
import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;
import com.deenayn.search.fight.engine.google.request.GoogleRequest;
import com.deenayn.search.fight.engine.google.response.GoogleResponse;
import com.deenayn.search.fight.engine.google.response.GoogleResponseBody;
import com.deenayn.search.fight.service.http.sender.HttpSender;
import com.deenayn.search.fight.service.http.sender.entity.HttpRequest;
import com.deenayn.search.fight.service.http.sender.entity.HttpResult;
import com.deenayn.search.fight.service.http.sender.entity.enums.HttpMethodType;

public class GoogleSearch extends SearchEngine<GoogleRequest, GoogleResponse> {

    private HttpSender sender;

    public GoogleSearch(HttpSender sender) {
        super(SearchEngineType.GOOGLE);
        this.sender = sender;
    }

    @Override
    public GoogleResponse query(GoogleRequest request) throws Exception {
        HttpRequest httpRequest = new HttpRequest.Builder(ApplicationConfig.getInstance().getGoogleHost())
                .setType(HttpMethodType.GET)
                .setParams(request.getParams().toMap())
                .build();
        HttpResult result = sender.execute(httpRequest);
        return new GoogleResponse(new GoogleResponseBody(result.getBody()), result.getHeaders());
    }
}
