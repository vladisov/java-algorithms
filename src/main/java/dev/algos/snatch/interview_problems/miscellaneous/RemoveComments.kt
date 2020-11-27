package dev.algos.snatch.interview_problems.miscellaneous

class RemoveComments {

    /**
     * Time O(S)
     * Space O(S)
     */
    fun removeComments(source: Array<String>): List<String> {
        val result = mutableListOf<String>()
        var open = 0
        val sb = StringBuilder()

        for (str in source) {
            var i = 0
            while (i < str.length) {
                if (i < str.length - 1 && str[i] == '/' && str[i + 1] == '*') {
                    if (open == 0) {
                        open++
                        i++
                    }
                } else if (i < str.length - 1 && str[i] == '*' && str[i + 1] == '/') {
                    if (open > 0) {
                        open--
                        i++
                    } else if (i + 2 < str.length && str[i + 1] != '/') {
                        sb.append(str[i])
                        sb.append(str[i + 1])
                        i++
                    } else {
                        sb.append(str[i])
                    }
                } else if (i < str.length - 1 && str[i] == '/' && str[i + 1] == '/') {
                    if (open == 0) break
                } else if (open == 0) {
                    sb.append(str[i])
                }
                i++
            }
            if (open <= 0) {
                if (sb.isNotEmpty()) {
                    result.add(sb.toString())
                }
                sb.clear()
            }

        }
        return result
    }
}
