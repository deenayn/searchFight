package com.deenayn.search.fight.service.http.sender;

import com.deenayn.search.fight.service.http.sender.entity.HttpRequest;
import com.deenayn.search.fight.service.http.sender.entity.HttpResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpUrlConnectionSender implements HttpSender {

    public HttpResult execute(HttpRequest request) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(createURLWithParams(request.getUrl(), request.getParams()));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (request.getType() != null) {
                connection.setRequestMethod(request.getType().getName());
            }
            if (request.getHeaders() != null) {
                request.getHeaders().forEach(connection::setRequestProperty);
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
            }

            return new HttpResult(content.toString(), connection.getHeaderFields());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    String createURLWithParams(String url, Map<String, String> params) {
        return url + "?" + transformParamsToString(params);
    }

    String transformParamsToString(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        if (params != null) {
            params.forEach((key, value) -> {
                try {
                    if (key != null && value != null) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("&");
                        }
                        stringBuilder.append(key).append("=").append(URLEncoder.encode(value, StandardCharsets.UTF_8.toString()));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        return stringBuilder.toString();
    }
}
