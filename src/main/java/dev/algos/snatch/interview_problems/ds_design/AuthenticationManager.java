package dev.algos.snatch.interview_problems.ds_design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/design-authentication-manager
 */
public class AuthenticationManager {
    private final Map<String, Integer> map;
    private final TreeMap<Integer, String> treeMap;
    private final int ttl;

    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
        ttl = timeToLive;
    }

    /**
     * O(logn) all operations
     */
    public void generate(String tokenId, int currentTime) {
        int expTime = currentTime + ttl;
        map.put(tokenId, expTime);
        treeMap.put(expTime, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) return;
        int oldTime = map.get(tokenId);
        if (oldTime <= currentTime) return;
        int expTime = currentTime + ttl;
        treeMap.remove(oldTime);
        treeMap.put(expTime, tokenId);
        map.put(tokenId, expTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        return treeMap.tailMap(currentTime, false).size();
    }
}
