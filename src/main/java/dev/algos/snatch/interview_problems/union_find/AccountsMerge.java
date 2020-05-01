package dev.algos.snatch.interview_problems.union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */
public class AccountsMerge {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToId.containsKey(email)) {
                    int preIndex = emailToId.get(email);
                    uf.union(preIndex, i);
                } else {
                    emailToId.put(email, i);
                }
            }
        }
        Map<Integer, TreeSet<String>> users = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.root(i);
            List<String> email = accounts.get(i);
            users.putIfAbsent(root, new TreeSet<>());
            users.get(root).addAll(email.subList(1, email.size()));
        }
        List<List<String>> result = new ArrayList<>();
        for (var entry : users.entrySet()) {
            int userId = entry.getKey();
            String name = accounts.get(userId).get(0);
            LinkedList<String> emails = new LinkedList<>(entry.getValue());
            emails.addFirst(name);
            result.add(emails);
        }
        return result;
    }

    public List<List<String>> accountsMergeDFS(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (var account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.putIfAbsent(account.get(i), account.get(0));
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        List<List<String>> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (var email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> list = new ArrayList<>();
                dfs(email, graph, list, visited);
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                result.add(list);
            }
        }
        return result;
    }

    private void dfs(String email, Map<String, Set<String>> graph, List<String> tmp, Set<String> visited) {
        tmp.add(email);
        visited.add(email);
        for (var nei : graph.get(email)) {
            if (!visited.contains(nei)) {
                dfs(nei, graph, tmp, visited);
            }
        }
    }

    static class UnionFind {
        int[] arr;

        public UnionFind(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }

        void union(int i, int j) {
            int p = root(i);
            int q = root(j);
            arr[p] = q;
        }

        private int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }
    }
}
