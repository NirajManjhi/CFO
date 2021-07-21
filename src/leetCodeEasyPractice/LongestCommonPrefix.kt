package leetCodeEasyPractice

object LongestCommonPrefix {

    @JvmStatic
    fun main(args: Array<String>) {
        longestCommonPrefix(arrayOf("flower", "flow", "flash"))
    }

    private fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        var len = strs[0].length
        if (len == 0) {
            return ""
        }
        for (i in 1 until strs.size) {
            val currentStr = strs[i]
            if (currentStr.length < len) {
                len = currentStr.length
            }
            for (j in 0..len) {
                if (strs[0][j] != currentStr[j]) {
                    len = j
                    break
                }
            }
        }
        return strs[0].substring(0, len)
    }
}