package com.deenayn.search.fight.engine.bing.request;

import com.deenayn.search.fight.engine.bing.request.enums.BingRequestFieldsEnum;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class BingRequestParamsTest {

    private String query = "the biggest sandwich";

    @Test
    public void testToMapExists() {
        BingRequestParams params = new BingRequestParams(query);
        Map<String, String> map = params.toMap();
        assertNotNull(map);
    }

    @Test
    public void testToMapNotEmpty() {
        BingRequestParams params = new BingRequestParams(query);
        Map<String, String> map = params.toMap();
        assertFalse(map.isEmpty());
    }

    @Test
    public void testToMapContainsValues() {
        BingRequestParams params = new BingRequestParams(query);
        Map<String, String> map = params.toMap();
        assertEquals(query, map.get(BingRequestFieldsEnum.Query.getName()));
    }
}