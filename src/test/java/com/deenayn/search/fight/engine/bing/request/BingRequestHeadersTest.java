package com.deenayn.search.fight.engine.bing.request;

import com.deenayn.search.fight.engine.bing.request.enums.BingRequestFieldsEnum;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class BingRequestHeadersTest {

    private String key = "jdkd3kv8ja8sas";

    @Test
    public void testToMapExists() {
        BingRequestHeaders headers = new BingRequestHeaders(key);
        Map<String, String> map = headers.toMap();
        assertNotNull(map);
    }

    @Test
    public void testToMapNotEmpty() {
        BingRequestHeaders headers = new BingRequestHeaders(key);
        Map<String, String> map = headers.toMap();
        assertFalse(map.isEmpty());
    }

    @Test
    public void testToMapContainsValues() {
        BingRequestHeaders headers = new BingRequestHeaders(key);
        Map<String, String> map = headers.toMap();
        assertEquals(key, map.get(BingRequestFieldsEnum.Key.getName()));
    }
}