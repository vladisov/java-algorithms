package dev.algos.snatch.interview_problems.tree_dfs;

import dev.algos.snatch.interview_problems.helpers.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return List.of();
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        find(root, map, result);
        return result;
    }

    private String find(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) return "X";
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }

        String left = find(root.left, map, result);
        if (!left.equals("X") && map.getOrDefault(left, 0) == 1) {
            result.add(root.left);
        }
        map.put(left, map.getOrDefault(left, 0) + 1);
        String right = find(root.right, map, result);
        if (!right.equals("X") && map.getOrDefault(right, 0) == 1) {
            result.add(root.right);
        }
        map.put(right, map.getOrDefault(right, 0) + 1);
        return left + "," + right + "," + root.val;
    }

}
