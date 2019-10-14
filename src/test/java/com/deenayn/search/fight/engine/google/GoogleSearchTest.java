package com.deenayn.search.fight.engine.google;

import com.deenayn.search.fight.engine.google.request.GoogleRequest;
import com.deenayn.search.fight.engine.google.request.GoogleRequestParams;
import com.deenayn.search.fight.engine.google.response.GoogleResponse;
import com.deenayn.search.fight.service.http.sender.HttpSender;
import com.deenayn.search.fight.service.http.sender.HttpSenderMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoogleSearchTest {

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
        GoogleSearch search = new GoogleSearch(sender);
        GoogleRequestParams params = new GoogleRequestParams("hyg7jnsadasd", "dsada8fa434:jjd8k", "gods");
        GoogleResponse response = search.query(new GoogleRequest(params));
        assertNotNull(response.getBody());
        assertEquals(400000000L, response.getBody().getTotalResults());
    }

}