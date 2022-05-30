package dev.algos.snatch.interview_problems.ds_design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class FileSystem {
    private final Node root;

    public FileSystem() {
        this.root = new Node("", false);
    }

    public List<String> ls(String path) {
        String[] split = path.split("/");
        Node curr = root;
        for (String s : split) {
            if (s.isEmpty()) continue;
            if (curr.children.get(s).isFile) {
                return List.of(s);
            }
            curr = curr.children.get(s);
        }
        List<String> result = new ArrayList<>();
        for (var entry : curr.children.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }

    public void mkdir(String path) {
        String[] split = path.split("/");
        Node curr = root;
        for (String s : split) {
            if (s.isEmpty()) continue;
            if (curr.children.get(s) == null) curr.children.put(s, new Node("", false));
            curr = curr.children.get(s);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] split = filePath.split("/");
        Node curr = root;
        for (String s : split) {
            if (s.isEmpty()) continue;
            if (curr.children.get(s) == null) curr.children.put(s, new Node("", false));
            curr = curr.children.get(s);
        }
        curr.isFile = true;
        curr.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] split = filePath.split("/");
        Node curr = root;
        for (String s : split) {
            if (s.isEmpty()) continue;
            if (curr.children.get(s) == null) return "";
            curr = curr.children.get(s);
        }
        return curr.content;
    }

    static class Node {
        boolean isFile;
        String content;
        TreeMap<String, Node> children;

        public Node(String content, boolean isFile) {
            this.isFile = isFile;
            this.content = content;
            this.children = new TreeMap<>();
        }
    }
}
