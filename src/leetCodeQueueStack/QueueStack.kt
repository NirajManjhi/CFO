package leetCodeQueueStack

import Node
import java.util.*

object QueueStack {

    @JvmStatic
    fun main(args: Array<String>) {
//        print("min distance is : ${bfs(getNodesTree(), getOneNode())}")
//        val grid = arrayOf(charArrayOf('1','1','1','1','0'), charArrayOf('1','1','0','1','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','0','0','0'))
//        val grid = arrayOf(charArrayOf('1','1','0','0','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','1','0','0'), charArrayOf('0','0','0','1','1'))
//        val grid = arrayOf(charArrayOf('1', '1', '1'), charArrayOf('0', '1', '0'), charArrayOf('1', '1', '1'))
//        print(numIslands(grid))
//        print(isValid("(){}"))
        dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
        printstd(*arrayOf("gg", "ff"))
        val a = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        a.sort()
    }

    fun printstd(vararg stu: String) {

    }
    private fun bfs(root: Node, target: Node): Int {
        val queue = LinkedList<Node>()
        var step = 0
        queue.add(root)
        while (queue.isNotEmpty()) {
            step++
            for (i in queue.indices) {
                val node = queue.first
                if (node == target) {
                    return step
                }
                node.neighbors?.forEach {
                    queue.add(it)
                }
                queue.poll()
            }
        }
        return -1
    }
//           j0  j1  j2
//   i = 0 ["1","1","1"]
//   i = 1 ["0","1","0"]
//   i = 2 ["1","1","1"]

    private fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0
        if (grid.isEmpty()) {
            return islands
        }
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    islands++
                    val queue = LinkedList<IntArray>()
                    queue.add(intArrayOf(i, j))
                    while (queue.isNotEmpty()) {
                        val intArray = queue.poll()
                        grid[intArray[0]][intArray[1]] = '2'
                        // top
                        if (intArray[0] - 1 >= 0 && grid[intArray[0] - 1][intArray[1]] == '1') {
                            queue.add(intArrayOf(intArray[0] - 1, intArray[1]))
                        }
                        // right
                        if (intArray[1] + 1 < grid[intArray[0]].size && grid[intArray[0]][intArray[1] + 1] == '1') {
                            queue.add(intArrayOf(intArray[0], intArray[1] + 1))
                        }
                        // down
                        if (intArray[0] + 1 < grid.size && grid[intArray[0] + 1][intArray[1]] == '1') {
                            queue.add(intArrayOf(intArray[0] + 1, intArray[1]))
                        }
                        // left
                        if (intArray[1] - 1 >= 0 && grid[intArray[0]][intArray[1] - 1] == '1') {
                            queue.add(intArrayOf(intArray[0], intArray[1] - 1))
                        }
                    }
                }
            }
        }
//        printlnisValid())
        return islands
    }

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        if (s.length < 2) {
            return false
        }
        val stack = Stack<Char>()
        for (i in s.indices) {
            val lastItem = if (stack.isNotEmpty()) stack.peek() else null
            if ((s[i] == ')' && lastItem == '(') || (s[i] == '}' && lastItem == '{') || (s[i] == ']' && lastItem == '[')) {
                stack.pop()
            } else {
                stack.push(s[i])
            }
        }
        return stack.isEmpty()
    }

    infix fun dailyTemperatures(T: IntArray): IntArray {
        /*val result = IntArray(temperatures.size)
        for (i in temperatures.indices) {
            for (j in i+1 until temperatures.size) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i
                    break
                }
            }
        }
        return result*/
        val arr = IntArray(T.size) {0}
        var stack = Stack<Int>()
        val a =

        /*for(i in T.indices) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()] ) {
                arr[stack.peek()] = i - stack.pop()
            }
            stack.push(i)
        }*/
        arr.forEach {
            println(it)
        }
        return arr
    }
}