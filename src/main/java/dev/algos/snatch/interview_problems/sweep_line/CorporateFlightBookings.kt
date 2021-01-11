package dev.algos.snatch.interview_problems.sweep_line

/**
 * Time O(N)
 * Space O(N)
 */
fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val flights = IntArray(n);
    for (booking in bookings) {
        flights[booking[0] - 1] += booking[2];
        if (booking[1] < flights.size)
            flights[booking[1]] -= booking[2];
    }
    for (i in 1 until n) {
        flights[i] += flights[i - 1]
    }
    return flights
}
