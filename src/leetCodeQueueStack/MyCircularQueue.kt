package leetCodeQueueStack

class MyCircularQueue(val k: Int) {

    private var list = ArrayList<Int>()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val obj = MyCircularQueue(3)
            println(obj.enQueue(1))
            println(obj.enQueue(2))
            println(obj.enQueue(3))
            println(obj.enQueue(4))
            println(obj.Rear())
            println(obj.isFull())
            println(obj.deQueue())
            println(obj.enQueue(4))
            println(obj.Rear())
        }
    }

    fun enQueue(value: Int): Boolean {
        if (list.size ?: 0 < k) {
            list.add(value)
            return true
        }
        return false
    }

    fun deQueue(): Boolean {
        if (list.isNotEmpty()) {
            list.removeAt(0)
            return true
        }
        return false
    }

    fun Front(): Int {
        if (list.isNotEmpty()){
            return list.first()
        }
        return -1
    }

    fun Rear(): Int {
        if (list.isNotEmpty()){
            return list.last()
        }
        return -1

    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    fun isFull(): Boolean {
        return list.size == k
    }
}