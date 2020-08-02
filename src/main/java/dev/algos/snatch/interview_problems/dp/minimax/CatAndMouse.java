package dev.algos.snatch.interview_problems.dp.minimax;

/**
 * A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.
 * <p>
 * The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.
 * <p>
 * Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.
 * <p>
 * During each player's turn, they must travel along one edge of the graph that meets where they are.  For example, if the Mouse is at node 1, it must travel to any node in graph[1].
 * <p>
 * Additionally, it is not allowed for the Cat to travel to the Hole (node 0.)
 * <p>
 * Then, the game can end in 3 ways:
 * <p>
 * If ever the Cat occupies the same node as the Mouse, the Cat wins.
 * If ever the Mouse reaches the Hole, the Mouse wins.
 * If ever a position is repeated (ie. the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
 * Given a graph, and assuming both players play optimally, return 1 if the game is won by Mouse, 2 if the game is won by Cat, and 0 if the game is a draw.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * Output: 0
 * Explanation:
 * 4---3---1
 * |   |
 * 2---5
 * \ /
 * 0
 */
public class CatAndMouse {

    /**
     * Time O(N^3)
     * Space O(N^3)
     */
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int res = helper(graph, 2, 1, 0, new Integer[n][n][n * 2]);
        return res == -1 ? 2 : res;
    }

    private int helper(int[][] graph, int cat, int mouse, int turn, Integer[][][] dp) {
        if (cat == mouse) return -1;
        if (mouse == 0) return 1;
        if (turn == graph.length * 2) return 0;

        if (dp[cat][mouse][turn] != null) return dp[cat][mouse][turn];
        int res = turn % 2 == 0 ? -1 : 1;
        if (turn % 2 == 0) {
            for (int i = 0; i < graph[mouse].length; i++) {
                res = Math.max(helper(graph, cat, graph[mouse][i], turn + 1, dp), res);
            }
        } else {
            for (int i = 0; i < graph[cat].length; i++) {
                if (graph[cat][i] == 0) continue;
                res = Math.min(helper(graph, graph[cat][i], mouse, turn + 1, dp), res);
            }
        }
        dp[cat][mouse][turn] = res;
        return res;
    }
}
