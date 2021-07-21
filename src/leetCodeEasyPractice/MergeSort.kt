package leetCodeEasyPractice

import leetCodeLinkedList.ListNode

object MergeSort {

    @JvmStatic
    fun main(args: Array<String>) {
        val a = sortList(ListNode.getSimpleLinkedListHead())
        println()
    }

    private fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val mid = MidOfLinkedList.getMidNode(head)
        val left = sortList(head)
        val right = sortList(mid)
        return MergeSortedList.mergeTwoLists(left, right)
    }
}