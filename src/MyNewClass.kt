import java.util.*
import kotlin.math.min

object MyNewClass {

    private var min = Int.MAX_VALUE
    fun getMaxValue(arr: Array<Int>): Int {
        // Write your code here
        arr.sort()
        if (arr.isNotEmpty() && arr.size == 1){
            return arr[0]
        }
        for (x in 0..arr.size - 2) {
            val difference = arr[x+1] - arr[x] - 1
            if (difference > 0) {
                arr[x+1] = arr[x+1] - difference
            }
        }
        arr.sort()
        return arr.last()
    }

    fun autocomplete(command: Array<String>): Array<Int> {
        // Write your code here
        val arr = IntArray(command.size)

        for (x in command.indices) {
            if (x == 0) {

            }
            var lastMatchedIndex = 0
            for (y in x-1 downTo 0) {

            }
            arr[x] = lastMatchedIndex
        }

        return arr.toTypedArray()
    }

    fun findSmallestDivisor(s: String, t: String): Int {
        // Write your code here
        val diffMod = s.length % t.length
        if (s.length < t.length || diffMod > 0) {
            return -1
        }
        var t1 = t
        val diff = s.length / t.length
        for (x in 1 until diff) {
            t1 += t
        }
        return if (s == t1) {
            findSmallestString(t).length
        } else {
            -1
        }
    }

    private fun findSmallestString(t: String) : String {
        if (t.length % 2 > 0) {
            return t
        }
        val halfTLength = t.length / 2
        val t1 = t.substring(0, halfTLength)
        if (t1 != t) {
            return t
        }
        return findSmallestString(t1)
    }

    private fun sumOfDigits(number: Int) : Int {
        if (number == 0) {
            return 0
        }
        val remainingNum = number/10
        val sum = number%10
        return sum + sumOfDigits(remainingNum)
    }

    private fun numSquaresBruteForce(num : Int, count : Int) {
        if (num == 0) {
            min = min(count, min)
            return
        }
        var i = 1
        while (i*i < num) {
            i++
            numSquaresBruteForce(num - (i*i), count + 1)
        }
    }

    private fun numSquaresDp(n : Int) : Int{
        if (n < 2) {
           return n
        }
        val dp = IntArray(n+1)
        Arrays.fill(dp, Int.MAX_VALUE)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            var j = 1
            while (i - (j*j) >= 0) {
                dp[i] = min(dp[i], dp[i-(j*j)] + 1)
                j++
            }
        }
        return dp[n]
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        val list = arrayListOf<Int>(1,2,5,6,8,9)
//        list.add(7, 3)
//        print(list)
//        val num = 100001
//        print(sumOfDigits(num))
//        numSquaresBruteForce(50, 0)
//        print(numSquaresDp(100))
//        print(min)
        val s = Stack<Int?>()
        s.push(null)
        s.push(null)
        s.push(1)
        print(s.toString())
    }
}