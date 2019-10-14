package com.deenayn.search.fight.engine.bing;

import com.deenayn.search.fight.engine.bing.request.BingRequest;
import com.deenayn.search.fight.engine.bing.request.BingRequestHeaders;
import com.deenayn.search.fight.engine.bing.request.BingRequestParams;
import com.deenayn.search.fight.engine.bing.response.BingResponse;
import com.deenayn.search.fight.service.http.sender.HttpSender;
import com.deenayn.search.fight.service.http.sender.HttpSenderMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BingSearchTest {

    private HttpSender sender;

    @Before
    public void setUp() {
        sender = new HttpSenderMock();
    }

    @After
    public void after() {
        sender = new HttpSenderMock();
    }

    @Test
    public void query() throws Exception {
        BingSearch search = new BingSearch(sender);
        BingRequest request = new BingRequest(new BingRequestHeaders("djakjs8dks66fj"), new BingRequestParams("cats"));
        BingResponse response = search.query(request);
        assertNotNull(response.getBody());
        assertEquals(500000000L, response.getBody().getTotalResults());
    }

}