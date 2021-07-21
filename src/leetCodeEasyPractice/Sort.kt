package leetCodeEasyPractice

import kotlin.math.min

class Sort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val a = selectionSort(intArrayOf(3, 6, 2, 9, 1, 0, 5))
//            val a = bubbleSort(intArrayOf(3, 6, 2, 9, 1, 0, 5))
//            val a = insertionSort(intArrayOf(3, 6, 2, 9, 1, 0, 5))
            val a = quickSort(intArrayOf(3, 6, 2, 9, 1, 0, 5), 0, 6)
            a.forEach {
                print("$it , ")
            }
        }

        /**
         * moving the smallest element to the left
         * time complexity O(n2)
         * space complexity O(1)
         */
        private fun selectionSort(arr: IntArray): IntArray {
            for (i in arr.indices) {
                var minIndex = i
                for (j in i + 1 until arr.size) {
                    if (arr[minIndex] > arr[j]) {
                        minIndex = j
                    }
                }
                swap(arr, minIndex, i)
            }
            return arr
        }

        /**
         * swap the elements with its adjacent element
         * time complexity O(n2)
         * space complexity O(1)
         */
        private fun bubbleSort(arr: IntArray): IntArray {
            arr.forEach { _ ->
                for (i in 0..arr.size - 2) {
                    if (arr[i] > arr[i + 1]) {
                        swap(arr, i, i + 1)
                    }
                }
            }
            return arr
        }

        /**
         * time complexity O(n2)
         * space complexity O(1)
         */
        private fun insertionSort(arr: IntArray): IntArray {
            for (i in 1 until arr.size) {
                val key = arr[i]
                var j = i - 1
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j]
                    j--
                }
                arr[j + 1] = key
            }
            return arr
        }

        /**
         * swap the elements with its adjacent element
         * time complexity O(n2)
         * space complexity O(1)
         */
        private fun quickSort(arr: IntArray, low: Int, high: Int): IntArray {
            if (low < high) {
                val pi = partition(arr, low, high)
                quickSort(arr, low, pi - 1)
                quickSort(arr, pi + 1, high)
            }
            return arr
        }

        private fun partition(arr: IntArray, low: Int, high: Int): Int {
            val pivot = arr[high]
            var i = low - 1
            for (j in low until high) {
                if (arr[j] <= pivot) {
                    i++
                    swap(arr, i, j)
                }
            }
            swap(arr, i + 1, high)
            return i + 1
        }

        private fun swap(arr: IntArray, pos1: Int, pos2: Int) {
            val temp = arr[pos1]
            arr[pos1] = arr[pos2]
            arr[pos2] = temp
        }
    }
}