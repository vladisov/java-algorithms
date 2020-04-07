package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

public class MinCostsForTickets {

    public int mincostTicketsBU(int[] days, int[] costs) {
        int[] dp = new int[366];
        boolean[] travelDay = new boolean[366];
        for (int day : days) {
            travelDay[day] = true;
        }
        for (int i = 1; i <= 365; i++) {
            if (i > days[days.length - 1]) {
                return dp[i - 1];
            }
            if (!travelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0], dp[i]);
            dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
            dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
        }

        return dp[365];
    }

    public int mincostTickets(int[] days, int[] costs) {
        Integer[][] dp = new Integer[days.length][366];
        return mincostTicketsRec(days, costs, 0, days[0], dp);
    }

    int mincostTicketsRec(int[] days, int[] costs, int index, int day, Integer[][] dp) {
        if (index >= days.length || day > days[days.length - 1]) {
            return 0;
        }
        if (dp[index][day] == null) {
            if (days[index] < day) {
                dp[index][day] = mincostTicketsRec(days, costs, index + 1, day, dp);
                return dp[index][day];
            }
            day = days[index];
            int cost1 = costs[0] + mincostTicketsRec(days, costs, index + 1, day + 1, dp);
            int cost2 = costs[1] + mincostTicketsRec(days, costs, index + 1, day + 7, dp);
            int cost3 = costs[2] + mincostTicketsRec(days, costs, index + 1, day + 30, dp);
            dp[index][day] = Math.min(cost1, Math.min(cost2, cost3));
        }

        return dp[index][day];
    }
}
