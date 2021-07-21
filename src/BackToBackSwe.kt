import sun.jvm.hotspot.memory.HeapBlock

object BackToBackSwe {

    @JvmStatic
    fun main(args: Array<String>) {
//        print(findMinWindowSubstring("whoopiepiesmakemyscalegroan", ""))
        print(isKEqualSumPossible(intArrayOf(4, 3, 2, 3, 5, 2, 2, 7), 4))
    }

    /*private fun kthMax(intArray: IntArray) : Int {
    }*/

    private fun isKEqualSumPossible(intArray: IntArray, k: Int): Boolean {
        var tempK = k
        val sumOfAll = intArray.sum()
        if (tempK <= 0 || sumOfAll % tempK != 0) {
            return false
        }
        val subArrayExpectedSum = sumOfAll / tempK
        val indicesUsed = ArrayList<Int>()
        while (tempK > 0) {
            val tempList = ArrayList<Int>()
            var sum = 0
            for (i in intArray.indices) {
                if (indicesUsed.contains(i)) {
                    continue
                }
                if ((sum + intArray[i]) < subArrayExpectedSum) {
                    sum += intArray[i]
                    tempList.add(i)
                } else if ((sum + intArray[i]) == subArrayExpectedSum) {
                    sum += intArray[i]
                    tempList.add(i)
                    indicesUsed.addAll(tempList)
                    tempK--
                    break
                } else if (tempK == 1) {
                    return false
                }
            }
            if (sum < subArrayExpectedSum){
                return false
            }
        }
        return true
    }

    private fun findMinWindowSubstring(baseString: String, target: String): String? {
        var rightIndex = 0
        var leftIndex = 0
        var minWindowLengthSeenSoFar = Int.MAX_VALUE
        var result = "NA"
        if (target.isBlank()) {
            return result
        }
        while (rightIndex < baseString.length) {
            if (rightIndex - leftIndex < target.length - 1) {
                rightIndex++
                continue
            }
            val currentWindow = baseString.substring(leftIndex, rightIndex + 1)
            if (isCurrentMatchesTarget(currentWindow, target)) {
                if (currentWindow.length < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = currentWindow.length
                    result = currentWindow
                }
                leftIndex++
            } else {
                rightIndex++
            }
        }
        return result
    }

    private fun isCurrentMatchesTarget(current: String, target: String): Boolean {
        target.forEach {
            if (!current.contains(it)) {
                return false
            }
        }
        return true
    }
}