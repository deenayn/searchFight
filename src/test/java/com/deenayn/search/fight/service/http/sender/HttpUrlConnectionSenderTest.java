package com.deenayn.search.fight.service.http.sender;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HttpUrlConnectionSenderTest {

    @Test
    public void testCreateURLWithParams() {
        HttpUrlConnectionSender sender = new HttpUrlConnectionSender();
        Map<String, String> params = new HashMap<>();
        params.put("key", "jd8jfna8sd");
        params.put("size", "1024");
        params.put("query", "cats");

        assertEquals("www.google.com?size=1024&query=cats&key=jd8jfna8sd", sender.createURLWithParams("www.google.com", params));
    }

    @Test
    public void transformParamsToString() {
        HttpUrlConnectionSender sender = new HttpUrlConnectionSender();
        Map<String, String> params = new HashMap<>();
        params.put("key", "jd8jfna8sd");
        params.put("size", "1024");
        params.put("query", "cats");

        assertEquals("size=1024&query=cats&key=jd8jfna8sd", sender.transformParamsToString(params));
    }
}