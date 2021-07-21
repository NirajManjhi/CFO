package leetCodeEasyPractice

import leetCodeLinkedList.ListNode

object ReverseLinkedList {

    var stop: Boolean = false
    private lateinit var leftNode : ListNode
    @JvmStatic
    fun main(args: Array<String>) {
        var linkedList = ListNode.getSimpleLinkedListHead()
        do {
            print("${linkedList.`val`} , ")
            linkedList = linkedList.next ?: break
        } while (true)
        println()
        var reversedLinkedList = reverseBetween(ListNode.getSimpleLinkedListHead(), 3, 6)
        do {
            print("${reversedLinkedList?.`val`} , ")
            reversedLinkedList = reversedLinkedList?.next ?: break
        } while (true)
    }

    private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        this.leftNode = head ?: return null
        recurseAndReverse(head, left, right)
        return head
    }

    private fun recurseAndReverse(rightNode: ListNode, left: Int, right: Int) {
        if (right == 1) {
            return
        }

        val rightNodeTemp = rightNode.next ?: return
        if (left > 1) {
            leftNode = leftNode.next ?: return
        }

        recurseAndReverse(rightNodeTemp, left - 1, right -1)
        if (leftNode == rightNodeTemp || rightNodeTemp.next == leftNode) {
            this.stop = true
        }

        if (!stop) {
            val l = leftNode.`val`
            leftNode.`val` = rightNodeTemp.`val`
            rightNodeTemp.`val` = l
            this.leftNode = leftNode.next ?: return
        }
    }
}