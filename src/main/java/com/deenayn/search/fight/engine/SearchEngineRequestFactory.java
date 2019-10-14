package com.deenayn.search.fight.engine;

import com.deenayn.search.fight.config.ApplicationConfig;
import com.deenayn.search.fight.engine.bing.request.BingRequest;
import com.deenayn.search.fight.engine.bing.request.BingRequestHeaders;
import com.deenayn.search.fight.engine.bing.request.BingRequestParams;
import com.deenayn.search.fight.engine.entity.SearchEngineRequest;
import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;
import com.deenayn.search.fight.engine.google.request.GoogleRequest;
import com.deenayn.search.fight.engine.google.request.GoogleRequestParams;

import javax.xml.crypto.NoSuchMechanismException;

public class SearchEngineRequestFactory {

    public SearchEngineRequest create(SearchEngineType type, String query) throws NoSuchMechanismException {
        ApplicationConfig config = ApplicationConfig.getInstance();
        switch (type) {
            case GOOGLE:
                return new GoogleRequest(new GoogleRequestParams(config.getGoogleKey(), config.getGoogleCx(), query));
            case BING:
                return new BingRequest(new BingRequestHeaders(config.getBingKey()), new BingRequestParams(query));
            default:
                throw new NoSuchMechanismException(type.getName());
        }
    }
}
