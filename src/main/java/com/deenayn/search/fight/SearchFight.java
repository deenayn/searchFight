package com.deenayn.search.fight;

import com.deenayn.search.fight.engine.SearchEngine;
import com.deenayn.search.fight.engine.SearchEngineRequestFactory;
import com.deenayn.search.fight.engine.entity.SearchEngineResponse;
import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;
import com.deenayn.search.fight.entity.SearchResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchFight {

    private List<SearchEngine> engines;

    public SearchFight(List<SearchEngine> engines) {
        this.engines = engines;
    }

    public void run(List<String> queries) throws Exception {
        if (queries.size() > 0) {
            SearchEngineRequestFactory requestFactory = new SearchEngineRequestFactory();
            List<SearchResult> results = new ArrayList<>();
            for (String query : queries) {
                SearchResult result = new SearchResult(query);
                System.out.print(query + ": ");
                for (SearchEngine engine : engines) {
                    SearchEngineResponse response = engine.query(requestFactory.create(engine.getType(), query));
                    System.out.print(engine.getType().getName() + ": " + response.getTotal() + " ");
                    result.addTotalResult(engine.getType(), response.getTotal());
                }
                System.out.println();
                results.add(result);
            }

            for (SearchEngine engine : engines) {
                System.out.println(engine.getType().getName() + " winners: " + getBestEngineResult(engine.getType(), results).getQuery());
            }
            System.out.println("Total winner: " + getBestTotalResult(results).getQuery());
        } else {
            System.out.println("No queries");
        }
    }

    SearchResult getBestEngineResult(SearchEngineType type, List<SearchResult> list) {
        return list.stream()
                .max(Comparator.comparing(r -> r.getTotalValuesMap().get(type)))
                .orElseThrow(NoSuchElementException::new);
    }

    SearchResult getBestTotalResult(List<SearchResult> list) {
        return list.stream()
                .max(Comparator.comparing(r ->
                        (Long) r.getTotalValuesMap().values().stream()
                                .mapToLong(Long::longValue).sum()))
                .orElseThrow(NoSuchElementException::new);
    }
}
