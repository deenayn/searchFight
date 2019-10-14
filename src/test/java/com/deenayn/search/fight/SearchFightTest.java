package com.deenayn.search.fight;

import com.deenayn.search.fight.engine.SearchEngine;
import com.deenayn.search.fight.engine.bing.BingSearch;
import com.deenayn.search.fight.engine.entity.enums.SearchEngineType;
import com.deenayn.search.fight.engine.google.GoogleSearch;
import com.deenayn.search.fight.entity.SearchResult;
import com.deenayn.search.fight.service.http.sender.HttpSender;
import com.deenayn.search.fight.service.http.sender.HttpSenderMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class SearchFightTest {

    private List<SearchEngine> searchEngines;

    @Before
    public void setUp() {
        HttpSender sender = new HttpSenderMock();
        searchEngines = Arrays.asList(new GoogleSearch(sender), new BingSearch(sender));
    }

    @After
    public void after() {
        searchEngines = null;
    }

    @Test
    public void testRunEmpty() throws Exception {
        SearchFight searchFight = new SearchFight(searchEngines);
        searchFight.run(new ArrayList<>());
    }

    @Test
    public void testRunFull() throws Exception {
        SearchFight searchFight = new SearchFight(searchEngines);
        List<String> queries = new ArrayList<>();
        queries.add("java");
        queries.add("c++");
        queries.add("kotlin");
        searchFight.run(queries);
    }

    @Test
    public void testGetBestGoogleResult() {
        SearchFight searchFight = new SearchFight(searchEngines);
        SearchResult playstation = new SearchResult("playstation")
                .addTotalResult(SearchEngineType.GOOGLE, 1_000_000L)
                .addTotalResult(SearchEngineType.BING, 400_000L);
        SearchResult nintendo = new SearchResult("nintendo")
                .addTotalResult(SearchEngineType.GOOGLE, 2_000_000L)
                .addTotalResult(SearchEngineType.BING, 600_000L);
        SearchResult xBox = new SearchResult("xBox")
                .addTotalResult(SearchEngineType.GOOGLE, 500_000L)
                .addTotalResult(SearchEngineType.BING, 700_000L);

        assertEquals(nintendo, searchFight.getBestEngineResult(SearchEngineType.GOOGLE, Arrays.asList(playstation, nintendo, xBox)));
    }

    @Test
    public void testGetBestBingResult() {
        SearchFight searchFight = new SearchFight(searchEngines);
        SearchResult playstation = new SearchResult("playstation")
                .addTotalResult(SearchEngineType.GOOGLE, 1_000_000L)
                .addTotalResult(SearchEngineType.BING, 400_000L);
        SearchResult nintendo = new SearchResult("nintendo")
                .addTotalResult(SearchEngineType.GOOGLE, 2_000_000L)
                .addTotalResult(SearchEngineType.BING, 600_000L);
        SearchResult xBox = new SearchResult("xBox")
                .addTotalResult(SearchEngineType.GOOGLE, 500_000L)
                .addTotalResult(SearchEngineType.BING, 700_000L);

        assertEquals(xBox, searchFight.getBestEngineResult(SearchEngineType.BING, Arrays.asList(playstation, nintendo, xBox)));
    }

    @Test
    public void testGetBestTotalResult() {
        SearchFight searchFight = new SearchFight(searchEngines);
        SearchResult playstation = new SearchResult("playstation")
                .addTotalResult(SearchEngineType.GOOGLE, 1_900_000L)
                .addTotalResult(SearchEngineType.BING, 800_000L);
        SearchResult nintendo = new SearchResult("nintendo")
                .addTotalResult(SearchEngineType.GOOGLE, 2_000_000L)
                .addTotalResult(SearchEngineType.BING, 600_000L);
        SearchResult xBox = new SearchResult("xBox")
                .addTotalResult(SearchEngineType.GOOGLE, 500_000L)
                .addTotalResult(SearchEngineType.BING, 900_000L);

        assertEquals(playstation, searchFight.getBestTotalResult(Arrays.asList(playstation, nintendo, xBox)));
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetEngineBestResultWithEmptyList() {
        SearchFight searchFight = new SearchFight(searchEngines);
        List<SearchResult> list = new ArrayList<>();
        searchFight.getBestEngineResult(SearchEngineType.BING, list);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetBestTotalResultWithEmptyList() {
        SearchFight searchFight = new SearchFight(searchEngines);
        List<SearchResult> list = new ArrayList<>();
        searchFight.getBestTotalResult(list);
    }
}