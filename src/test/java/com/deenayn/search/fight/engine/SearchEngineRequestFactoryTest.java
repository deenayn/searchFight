package com.deenayn.search.fight.engine;

import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchEngineRequestFactoryTest {

    @Test
    public void createGoogleRequest() {
        SearchEngineRequestFactory factory = new SearchEngineRequestFactory();
        String query = "cats";
        assertEquals(query, factory.create(SearchEngineType.GOOGLE, query).getQuery());
    }

    @Test
    public void createBingRequest() {
        SearchEngineRequestFactory factory = new SearchEngineRequestFactory();
        String query = "dogs";
        assertEquals(query, factory.create(SearchEngineType.BING, query).getQuery());
    }
}