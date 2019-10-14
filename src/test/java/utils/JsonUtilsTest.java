package utils;

import org.junit.Test;

import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JsonUtilsTest {

    private String totalResultsName = "totalResults";
    private Long totalResultsValue = 400000000L;

    @Test
    public void testGetLongValueFromNumberAsStringField() throws NoSuchFileException {
        String json = FileUtils.readFile(getClass(), "json/1.json");
        assertEquals(totalResultsValue, JsonUtils.getLongValue(totalResultsName, json));
    }

    @Test
    public void testGetLongValueFromNumberField() throws NoSuchFileException {
        String json = FileUtils.readFile(getClass(), "json/2.json");
        assertEquals(totalResultsValue, JsonUtils.getLongValue(totalResultsName, json));
    }

    @Test
    public void testGetLongValueFromNonExistsField() throws NoSuchFileException {
        String json = FileUtils.readFile(getClass(), "json/3.json");
        assertNull(JsonUtils.getLongValue(totalResultsName, json));
    }

    @Test
    public void testGetLongValueFromOnlyOneField() throws NoSuchFileException {
        String json = FileUtils.readFile(getClass(), "json/4.json");
        assertEquals(totalResultsValue, JsonUtils.getLongValue(totalResultsName, json));
    }

    @Test
    public void testGetLongValueFromStringField() throws NoSuchFileException {
        String json = FileUtils.readFile(getClass(), "json/5.json");
        assertNull(JsonUtils.getLongValue(totalResultsName, json));
    }
}