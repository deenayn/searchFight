package com.deenayn.search.fight.service.http.sender;

import com.deenayn.search.fight.service.http.sender.entity.HttpRequest;
import com.deenayn.search.fight.service.http.sender.entity.HttpResult;

public interface HttpSender {

    HttpResult execute(HttpRequest request) throws Exception;
}
