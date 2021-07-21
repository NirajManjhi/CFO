package leetCodeEasyPractice

object TwoSum {

    @JvmStatic
    fun main(args: Array<String>) {
        val intArr = intArrayOf(-1, 0, 1, 2, -1, -4)
        twoSum(intArr, 5)
    }

    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val remaining = target - nums[i]
            if (map.containsKey(remaining)) {
                return intArrayOf(map[remaining]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}