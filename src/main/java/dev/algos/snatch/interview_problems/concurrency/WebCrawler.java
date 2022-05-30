package dev.algos.snatch.interview_problems.concurrency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * https://leetcode.com/problems/web-crawler-multithreaded/
 */
public class WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> seen = ConcurrentHashMap.newKeySet();
        ExecutorService executorService = Executors.newFixedThreadPool(10, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        String hostname = getHost(startUrl);
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        Queue<CompletableFuture<Void>> tasks = new ArrayDeque<>();
        queue.add(startUrl);
        while (true) {
            String url = queue.poll();
            if (url != null) {
                if (!seen.contains(url) && isSameHost(hostname, url)) {
                    seen.add(url);
                    CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                        List<String> urls = htmlParser.getUrls(url);
                        urls.forEach(queue::offer);
                        return null;
                    });
                    tasks.add(future);
                }
            } else {
                if (!tasks.isEmpty()) {
                    CompletableFuture<Void> future = tasks.poll();
                    try {
                        future.get();
                    } catch (InterruptedException | ExecutionException ignored) {
                    }
                } else break;
            }
        }
        return new ArrayList<>(seen);
    }

    private boolean isSameHost(String hostname, String url) {
        return getHost(url).equals(hostname);
    }

    private String getHost(String url) {
        int i = url.indexOf("/", 7);
        if (i != -1) return url.substring(0, i);
        return url;
    }


    interface HtmlParser {
        List<String> getUrls(String url);
    }
}

