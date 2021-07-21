package leetCodeEasyPractice

object ReverseInteger {

    @JvmStatic
    fun main(args: Array<String>) {
        reverse(524)
    }

    private fun reverse(x: Int): Int {
        if (x >= Int.MAX_VALUE) {
            return 0
        }
        var temp = x
        var result = 0
        while (temp != 0) {
            val last = temp % 10
            temp /= 10
            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && last > 7)) return 0
            if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && last < -8)) return 0
            result = result * 10 + last
        }
        return result
    }
}