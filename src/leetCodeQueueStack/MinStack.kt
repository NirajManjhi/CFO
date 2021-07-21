package leetCodeQueueStack

class MinStack() {

    private val arr = ArrayList<HashMap<Int, Int>>()

    fun push(value: Int) {
        var minValue = if (arr.isEmpty()){
            value
        } else {
            arr.last().keys.first()
        }
        minValue = Math.min(minValue, value)
        arr.add(hashMapOf(Pair(minValue, value)))
    }

    fun pop() {
        if (arr.isNotEmpty()) {
            arr.removeAt(arr.lastIndex)
        }
    }

    fun top(): Int? {
        return if (arr.isEmpty()) {
            null
        } else {
            arr.last().values.first()
        }
    }

    fun getMin(): Int? {
        if (arr.isEmpty()){
            return null
        }
        return arr.last().keys.first()
    }
}