package dev.algos.snatch.interview_problems.greedy

/**
 *  You have an inventory of different colored balls, and there is a customer that wants orders balls of any color.
The customer weirdly values the colored balls. Each colored ball's value is
the number of balls of that color you currently have in your inventory.
For example, if you own 6 yellow balls, the customer would pay 6 for the first yellow ball.
After the transaction, there are only 5 yellow balls left,
so the next yellow ball is then valued at 5 (i.e., the value of the balls decreases as you sell more to the customer).
You are given an integer array, inventory, where inventory[i] represents the number of balls of the ith color
that you initially own. You are also given an integer orders, which represents the total number of balls that the customer wants. You can sell the balls in any order.
Return the maximum total value that you can attain after selling orders colored balls. As the answer may be too large,
return it modulo 10^9 + 7.
 */
class MaxProfitBalls {

    /**
     * Time O(NlogN)
     * Space O(1)
     */
    fun maxProfit(inventory: IntArray, _orders: Int): Int {
        var orders = _orders
        inventory.sortDescending()
        var ans: Long = 0;
        var i = 0;
        val n = inventory.size
        while (orders > 0) {
            val width = i + 1
            val diff = inventory[i] - if (i < n - 1) inventory[i + 1] else inventory[i]
            if (i < n - 1 && inventory[i] - inventory[i + 1] > 0 && orders >= width * diff) {
                // get it equal first
                ans = (ans + width * sum(inventory[i].toLong(), inventory[i + 1].toLong())) % 1_000_000_007
                orders -= width * diff
            } else if (i == n - 1 || diff > 0) {
                val rows = orders / width
                val cols = orders % width
                ans = (ans + width * sum(inventory[i].toLong(), inventory[i] - rows.toLong())) % 1_000_000_007
                ans = (ans + cols.toLong() * (inventory[i] - rows)) % 1_000_000_007
                orders = 0
            }
            i++
        }
        return ans.toInt()
    }

    private fun sum(from: Long, to: Long): Long {
        return (from * (from + 1) / 2 - to * (to + 1) / 2).toLong()
    }
}
