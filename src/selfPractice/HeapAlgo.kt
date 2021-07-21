package selfPractice

object HeapAlgo {

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(18, 9, 20, 8, 21, 1, 42, 2, 100, 45, 3)
        print("Actual array looks like")
        println()
        arr.forEach {
            print("$it  ")
        }
        println()
//        val maxHeap = createMaxHeap(arr)
//        deleteItemFromMaxHeap(maxHeap, maxHeap.size)
        heapSort(arr)
    }

    private fun createMaxHeap(intArray: IntArray): IntArray {
        if (intArray.size < 2) {
            return intArray
        }
        for (i in 1..intArray.size) {
            var currentIndex = i - 1
            var parentIndex = (i / 2) - 1
            val currentVal = intArray[currentIndex]
            while (parentIndex >= 0 && currentVal > intArray[parentIndex]) {
                intArray[currentIndex] = intArray[parentIndex]
                intArray[parentIndex] = currentVal
                currentIndex = parentIndex
                parentIndex = ((parentIndex + 1) / 2) - 1
            }
        }
        print("max heap array looks like")
        println()
        intArray.forEach {
            print("$it  ")
        }
        println()
        return intArray
    }

    private fun deleteItemFromMaxHeap(intArray: IntArray, heapSize: Int) {
        var currentIndex = 0
        var lastIndex = heapSize - 1
        val itemToDelete = intArray[currentIndex]
        intArray[currentIndex] = intArray[lastIndex]
        intArray[lastIndex] = itemToDelete
        lastIndex -= 1
        var leftChildIndex = ((currentIndex + 1) * 2) - 1
        var rightChildIndex = ((currentIndex + 1) * 2)
        while (leftChildIndex <= lastIndex && rightChildIndex <= lastIndex
                && (intArray[leftChildIndex] > intArray[currentIndex] || intArray[rightChildIndex] > intArray[currentIndex])) {
            if (intArray[leftChildIndex] > intArray[currentIndex]
                    && ((intArray[rightChildIndex] > intArray[currentIndex]
                            && intArray[leftChildIndex] > intArray[rightChildIndex])
                            || intArray[rightChildIndex] < intArray[currentIndex])) {
                val currentItem = intArray[currentIndex]
                intArray[currentIndex] = intArray[leftChildIndex]
                intArray[leftChildIndex] = currentItem
                currentIndex = leftChildIndex
            } else if (intArray[rightChildIndex] > intArray[currentIndex]
                    && ((intArray[leftChildIndex] > intArray[currentIndex]
                            && intArray[rightChildIndex] > intArray[leftChildIndex])
                            || intArray[leftChildIndex] < intArray[currentIndex])) {
                val currentItem = intArray[currentIndex]
                intArray[currentIndex] = intArray[rightChildIndex]
                intArray[rightChildIndex] = currentItem
                currentIndex = rightChildIndex
            }
            leftChildIndex = ((currentIndex + 1) * 2) - 1
            rightChildIndex = ((currentIndex + 1) * 2)
        }
    }

    private fun heapSort(intArray: IntArray) {
        val maxHeap = createMaxHeap(intArray)
        var heapSize = maxHeap.size
        maxHeap.forEach { _ ->
            deleteItemFromMaxHeap(maxHeap, heapSize)
            heapSize--
        }
        print("sorted array looks like")
        println()
        maxHeap.forEach {
            print("$it  ")
        }
        println()
    }
}