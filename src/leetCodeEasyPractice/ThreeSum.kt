package leetCodeEasyPractice

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

object ThreeSum {

    @JvmStatic
    fun main(args: Array<String>) {
        val intArr = intArrayOf(-1, 0, 1, 2, -1, -4)
        threeSumZero(intArr)
    }

    private fun threeSumZero(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        Arrays.sort(nums)
        val setData = HashSet<List<Int>>()
        for (i in 0..nums.size - 2) {
            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum == 0 -> {
                        setData.add(listOf(nums[i], nums[j++], nums[k--]))
                    }
                    sum > 0 -> {
                        k--
                    }
                    sum < 0 -> {
                        j++
                    }
                }
            }
        }
        return ArrayList(setData)
    }
}