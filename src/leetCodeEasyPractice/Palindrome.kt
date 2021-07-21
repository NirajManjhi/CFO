package leetCodeEasyPractice

object Palindrome {

    @JvmStatic
    fun main(args: Array<String>) {
        isPalindrome(525)
    }

    private fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false
        }
        var temp = x
        var revertedNumber = 0
        while (temp > revertedNumber) {
            revertedNumber = revertedNumber * 10 + temp % 10
            temp /= 10
        }
        return temp == revertedNumber || temp == revertedNumber / 10
    }
}