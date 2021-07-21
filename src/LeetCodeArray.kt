object LeetCodeArray {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
        val num1 = intArrayOf(1,0,0,1,2,1,2,2)
        val num2 = intArrayOf(0, 0,0,0, 1, 0, 2)
//        print(findMaxConsecutiveOnes(list))
//        print(findNumbers(list))
//        print(sortedSquares(list))
//        duplicateZeros(list)
//        merge(num1, 2, num2, 4)
//        removeElement(num2, 4)
//        removeDuplicates(num2)
//        println("value is : ${validMountainArray(num2)}")
//        replaceElements(num2)
//        moveZeroes(num2)
//        sortArrayByParity(num1)
//        heightChecker(num1)
//        thirdMax(num1)
//        findDisappearedNumbers(num1)
        segregate(num1)
    }


    private fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = ArrayList<Int>()
        for (i in nums.indices) {
            result.add(i + 1)
        }
        nums.forEach {
            result.remove(it)
        }
        val numbersMap=mutableMapOf("one" to 1,"two" to 2, "three" to 3,"threeAgain" to 3)
        numbersMap.keys.remove("three")
        numbersMap.values.remove(1)
//        numbersMap.remo
        return result
    }

    private fun thirdMax(nums: IntArray): Int {
//        6,5,4,2
        nums.sortDescending()
        var max = 0
        var count = 1
        if (nums.size < 3) {
            return nums[0]
        }
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) {
                continue
            } else {
                count++
                if (count == 3) {
                    max = nums[i]
                    break
                }
            }
        }
        if (count < 3) {
            return nums[0]
        }
        print(max)
        return max
    }

    private fun heightChecker(heights: IntArray): Int {
        val expected = heights.copyOf().apply { sort() }
        var count = 0
        for (i in heights.indices) {
            if (heights[i] != expected[i]) {
                count++
            }
        }
        return count
    }

    private fun sortArrayByParity(nums: IntArray): IntArray {
//        1, 2, 3, 4, 5, 6, 7
        var x = -1
        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                if (x > -1) {
                    val t = nums[x]
                    nums[x] = nums[i]
                    nums[i] = t
                    x++
                }
            } else if (i == 0 || (i > 0 && (nums[i - 1] % 2) == 0)) {
                x = i
            }
        }
        nums.forEach {
            print("$it, ")
        }
        return nums
    }

    private fun moveZeroes(nums: IntArray) {
//        0,0,1,2,3,0,4
        var x = -1
        for (i in nums.indices) {
            if (nums[i] != 0) {
                if (x > -1) {
                    nums[x] = nums[i]
                    nums[i] = 0
                    x++
                }
            } else if (i == 0 || (i > 0 && nums[i - 1] != 0)) {
                x = i
            }
        }
        nums.forEach {
            print("$it, ")
        }
    }

    private fun replaceElements(arr: IntArray): IntArray {
        arr.forEach {
            print("$it, ")
        }
        println()
        for (i in arr.indices) {
            if (i == arr.size - 1) {
                arr[i] = -1
                break
            }
            var biggestNo = arr[i + 1]
            for (j in i + 1 until arr.size) {
                if (arr[j] > biggestNo) {
                    biggestNo = arr[j]
                }
            }
            arr[i] = biggestNo
        }

        arr.forEach {
            print("$it, ")
        }
        return arr
    }

    private fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) {
            return false
        }
        val sortedArray = arr.copyOf()
        sortedArray.sortDescending()
        val tip = sortedArray[0]
        val tipIndex = arr.indexOf(tip)
        if (tipIndex > 0 && tipIndex < arr.size - 1) {
            var lastComparedInt = tip
            for (i in tipIndex - 1 downTo 0) {
                if (arr[i] >= lastComparedInt) {
                    return false
                }
                lastComparedInt = arr[i]
            }
            lastComparedInt = tip
            for (i in tipIndex + 1 until arr.size) {
                if (arr[i] >= lastComparedInt) {
                    return false
                }
                lastComparedInt = arr[i]
            }
            return true
        }
        return false
    }

    private fun checkIfExist(arr: IntArray): Boolean {
        var tempIndex = 0
        var nOrm = arr[tempIndex]
        while (tempIndex < arr.size) {
            for (i in tempIndex + 1 until arr.size) {
                if (nOrm % 2 == 0 && (nOrm / 2 == arr[i] || arr[i] == nOrm * 2)) {
                    return true
                } else if (nOrm % 2 != 0 && arr[i] == nOrm * 2) {
                    return true
                }
            }
            tempIndex++
            if (tempIndex < arr.size) {
                nOrm = arr[tempIndex]
            }
        }
        return false
    }

    private fun removeDuplicates(nums: IntArray): Int {
        nums.forEach {
            print("$it, ")
        }
        println()

//        1,1,1,2,3,3,4
//        0,1,2,3,4,5,6
//        var len = nums.size
//        var tempIndex = nums.size-1
//        while (tempIndex > -1){
//            for (i in 1 until len) {
//                if (i >= len) {
//                    break
//                }
//                if (nums[i] == nums[i-1]) {
//                    for (j in i until len-1) {
//                        nums[j] = nums[j+1]
//                    }
//                    len--
//                    break
//                }
//            }
//            tempIndex--
//        }
        var i = 0
        for (j in 1 until nums.size) {
            if (nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
        }
        for (k in 0..i) {
            print("${nums[k]} ")
        }
        println()
        print(i + 1)
        return i + 1
    }

    private fun removeElement(nums: IntArray, value: Int): Int {
        nums.forEach {
            print("$it, ")
        }
        println()
//        0,4,4,0,4,4,4,0,2
//        0,1,2,3,4,5,6,7,8
//        0,4,0,4,4,4,0,2,2

        var len = nums.size
        var temp = nums.size - 1
        while (temp > -1) {
            for (i in 0 until len) {
                if (nums[i] == value) {
                    for (j in i until len - 1) {
                        nums[j] = nums[j + 1]
                    }
                    len--
                    break
                }
            }
            temp--
        }


        nums.forEach {
            print("$it, ")
        }
        println(len)
        return len
    }

    private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        nums1.forEach {
            print("$it, ")
        }
        println()
        nums2.forEach {
            print("$it, ")
        }
        for ((count, i) in (m until m + n).withIndex()) {
            nums1[i] = nums2[count]
        }
        nums1.sort()
        println()
        nums1.forEach {
            print("$it, ")
        }
    }

    private fun duplicateZeros(arr: IntArray): Unit {
        arr.forEach {
            print("$it, ")
        }
        var duplicatedIndex = -1
        for (i in arr.indices) {
            if (arr[i] == 0 && i > duplicatedIndex) {
                duplicatedIndex = i + 1
                for (j in arr.size - 1 downTo i + 1) {
                    arr[j] = arr[j - 1]
                }
            }
        }
        println()
        arr.forEach {
            print("$it, ")
        }
    }

    fun findNumbers(nums: IntArray): Int {
        return nums.map { it.toString() }.filter { it.length % 2 == 0 }.count()
    }

    fun sortedSquares(nums: IntArray): IntArray {
        val newArr: IntArray = nums.mapIndexed { index, it ->
            it * it
        }.toIntArray()
        newArr.sort()
        return newArr
    }

    // input = [0,2,3,1,3,1,1]
    // output = 2
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var cnt = 0
        for (element in nums) {
            if (element == 1) {
                cnt++
            } else {
                if (cnt > max) {
                    max = cnt
                }
                cnt = 0
            }
        }
        if (cnt > max) {
            return cnt
        }
        return max
    }

    private fun segregate(arr: IntArray) : IntArray {
        var pointer = 0
        for(i in 1 until arr.size) {
            if(pointer == i || arr[pointer] != arr[i]) {
                continue
            }
            pointer++
            val v = arr[pointer]
            arr[pointer] = arr[i]
            arr[i] = v
        }
        arr.forEach {
            print("$it, ")
        }
        return arr
    }
}