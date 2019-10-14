package com.deenayn.search.fight;

import com.deenayn.search.fight.engine.bing.BingSearch;
import com.deenayn.search.fight.engine.google.GoogleSearch;
import com.deenayn.search.fight.service.http.sender.HttpSender;
import com.deenayn.search.fight.service.http.sender.HttpUrlConnectionSender;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        HttpSender sender = new HttpUrlConnectionSender();
        SearchFight fight = new SearchFight(Arrays.asList(new GoogleSearch(sender), new BingSearch(sender)));
        try {
            fight.run(Arrays.asList(args));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
