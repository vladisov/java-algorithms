package dev.algos.snatch.interview_problems.two_heaps;

import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * <p>
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * <p>
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.
 * <p>
 * Example 1:
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * <p>
 * Output: 4
 * <p>
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * Note:
 * You may assume all numbers in the input are non-negative integers.
 * The length of Profits array and Capital array will not exceed 50,000.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO {

    /**
     * Time complexity O(NlogN+KlogN)
     * Space complexity O(N)
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        PriorityQueue<Project> minHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        int maxProjects = 0;
        int result = W;
        for (int i = 0; i < Capital.length; i++) {
            int capital = Capital[i];
            if (capital <= W) {
                maxHeap.add(new Project(capital, Profits[i]));
            } else {
                minHeap.add(new Project(capital, Profits[i]));
            }
        }

        while (maxProjects < k && !maxHeap.isEmpty()) {
            result += maxHeap.poll().profit;
            while (!minHeap.isEmpty() && minHeap.peek().capital <= result) {
                maxHeap.add(minHeap.poll());
            }
            maxProjects++;
        }
        return result;
    }

    public int findMaximumCapitalEducativeApproach(int[] capital, int[] profits,
                                                   int numberOfProjects,
                                                   int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

        // insert all project capitals to a min-heap
        for (int i = 0; i < n; i++)
            minCapitalHeap.offer(i);

        // let's try to find a total of 'numberOfProjects' best projects
        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            // find all projects that can be selected within the available capital and insert them in a max-heap
            while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
                maxProfitHeap.add(minCapitalHeap.poll());

            // terminate if we are not able to find any project that can be completed within the available capital
            if (maxProfitHeap.isEmpty())
                break;

            // select the project with the maximum profit
            availableCapital += profits[maxProfitHeap.poll()];
        }

        return availableCapital;
    }

    static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}
