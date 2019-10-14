package com.deenayn.search.fight.service.http.sender;

import com.deenayn.search.fight.service.http.sender.entity.HttpRequest;
import com.deenayn.search.fight.service.http.sender.entity.HttpResult;
import utils.FileUtils;

import java.util.HashMap;

public class HttpSenderMock implements HttpSender {

    @Override
    public HttpResult execute(HttpRequest request) throws Exception {
        return new HttpResult(FileUtils.readFile(getClass(), "json/1.json"), new HashMap<>());
    }
}
