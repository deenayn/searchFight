package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {

    public static Long getLongValue(String param, String json) {
        Matcher matcher = Pattern.compile(param + "\": \"?\\d+").matcher(json);
        if (matcher.find()) {
            return new Long(json.substring(matcher.start() + (param + "\": ").length(), matcher.end()).replace("\"", ""));
        } else {
            return null;
        }
    }
}
