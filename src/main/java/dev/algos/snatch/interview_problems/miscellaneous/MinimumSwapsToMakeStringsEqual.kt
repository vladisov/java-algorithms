package dev.algos.snatch.interview_problems.miscellaneous

class MinimumSwapsToMakeStringsEqual {
    /*
    xxyyxyxyxx
    xyyxyxxxyx

    xyxyyx
    yxyxxy

    x1 - 3, x2 - 3
    y1 - 3, y2 - 3
     */
    fun minimumSwap(s1: String, s2: String): Int {
        if (s1.length != s2.length) return -1
        var x1 = 0
        var x2 = 0
        var y1 = 0
        var y2 = 0
        for (i in s1.indices) {
            if (s1[i] == s2[i]) continue
            if (s1[i] == 'x') {
                x1++
                y2++
            } else {
                y1++
                x2++
            }
        }
        if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            return -1
        }

        /*
        one swap for
        xx or yy
        yy    xx
        and two swaps for
        xy  ->  yy  ->  xy
        yx      xx      xy
         */
        return x1 / 2 + y1 / 2 + (x1 % 2) * 2 //one swappers + two swapper
    }

    fun minimumSwapSimplified(s1: String, s2: String): Int {
        if (s1.length != s2.length) return -1
        var x1 = 0
        var y1 = 0
        for (i in s1.indices) {
            if (s1[i] == s2[i]) continue
            if (s1[i] == 'x') {
                x1++
            } else {
                y1++
            }
        }
        if ((x1 + y1) % 2 != 0) {
            return -1
        }
        return x1 / 2 + y1 / 2 + (x1 % 2) * 2 //one swappers + two swapper
    }
}
