package com.deenayn.search.fight.config;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationConfigTest {

    @Test
    public void testInitialization() {
        ApplicationConfig config = ApplicationConfig.getInstance();
        assertEquals("google_host", config.getGoogleHost());
        assertEquals("google_key", config.getGoogleKey());
        assertEquals("google_cx", config.getGoogleCx());
        assertEquals("bing_host", config.getBingHost());
        assertEquals("bing_key", config.getBingKey());
    }
}