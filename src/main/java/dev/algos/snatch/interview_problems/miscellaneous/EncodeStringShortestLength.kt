package dev.algos.snatch.interview_problems.miscellaneous

class EncodeStringShortestLength {

    /*
   2[abbb]c2[abbb]c
   */

    fun encode(s: String): String {

        for (i in 1 until s.length) {
            val pattern = s.substring(i)
            val times = count(s, pattern)
        }
        return ""
    }

    private fun count(str: String, pattern: String): Int {
        TODO("Not yet implemented")
    }

}
