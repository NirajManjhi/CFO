package leetCodeEasyPractice

object RomanToInt {

    @JvmStatic
    fun main(args: Array<String>) {
        romanToInt("XIV")
    }

    private fun romanToInt(s: String): Int {
        val map = mutableMapOf(
                'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000
        )
        if (s.length < 2) {
            return map[s[0]] ?: 0
        }
        var result = 0
        var pointer = s.length - 1
        while (pointer >= 0) {
            // XIX
            val a = map[s[pointer]] ?: 0 // X
            if (pointer > 0) {
                val b = map[s[pointer - 1]] ?: 0 // I
                if (a > b) {
                    result = result + a - b
                    pointer -= 2
                    continue
                }
            }
            pointer--
            result += a
        }
        return result
    }
}