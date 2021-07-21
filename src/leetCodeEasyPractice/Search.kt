package leetCodeEasyPractice

class Search {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(linearSearch(intArrayOf(1, 2, 3, 4, 5, 6, 7), 50))
            println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7), 0, 6, 6))
        }

        /**
         * time complexity O(n)
         * space complexity O(1)
         */
        private fun linearSearch(arr: IntArray, key: Int): Int {
            arr.forEachIndexed { index, it ->
                if (it == key) {
                    return index
                }
            }
            return -1
        }

        /**
         * time complexity O(log n)
         * space complexity O(1)
         */
        private fun binarySearch(arr: IntArray, startIndex: Int, endIndex: Int, key: Int) : Int {
            if (endIndex >= startIndex) {
                val mid = startIndex + (endIndex - startIndex) / 2
                return when {
                    arr[mid] == key -> {
                        mid
                    }
                    arr[mid] > key -> {
                        binarySearch(arr, startIndex, mid - 1, key)
                    }
                    else -> {
                        binarySearch(arr, mid + 1, endIndex, key)
                    }
                }
            }
            return -1
        }
    }
}