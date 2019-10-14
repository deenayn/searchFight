package com.deenayn.search.fight.engine.google.request;

import com.deenayn.search.fight.engine.google.request.enums.GoogleRequestParamsEnum;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class GoogleRequestParamsTest {

    private String key = "hd8ajsd6klad9f";
    private String cx = "8faskffkasf:888ssa";
    private String q = "the smallest pizza";

    @Test
    public void testToMapExists() {
        GoogleRequestParams request = new GoogleRequestParams(key, cx, q);
        Map<String, String> map = request.toMap();
        assertNotNull(map);
    }

    @Test
    public void testToMapNotEmpty() {
        GoogleRequestParams request = new GoogleRequestParams(key, cx, q);
        Map<String, String> map = request.toMap();
        assertFalse(map.isEmpty());
    }

    @Test
    public void testToMapContainsValues() {
        GoogleRequestParams request = new GoogleRequestParams(key, cx, q);
        String fields = "query(response(size))";
        Map<String, String> map = request.toMap();
        assertEquals(key, map.get(GoogleRequestParamsEnum.KEY.getName()));
        assertEquals(cx, map.get(GoogleRequestParamsEnum.CX.getName()));
        assertEquals(q, map.get(GoogleRequestParamsEnum.Q.getName()));
    }
}