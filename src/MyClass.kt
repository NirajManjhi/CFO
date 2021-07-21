
import java.util.*


class MyClass {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val o = MyClass()
//            o.printDiamond(5)

            val size = 5
            for (rowNumber in -size + 1 until size) {
                val row = CharArray(2 * size - Math.abs(rowNumber) - 1)
                Arrays.fill(row, 0, Math.abs(rowNumber), ' ')
                Arrays.fill(row, Math.abs(rowNumber), row.size, '*')
                println(String(row))
            }
        }
    }
    private fun printDiamond(num: Int) {
        for (i in 1..(num*2 -1)) {
            val space = (num - i) / 2
            recursiveCall(i, num)
            println()
        }
    }

    private fun recursiveCall(number: Int, actualNum:Int) {
        when(actualNum - number) {
            0 -> {
                print("*")
            }
            else -> {
                print("")
                recursiveCall(number + 1, actualNum)
            }
        }
    }

}