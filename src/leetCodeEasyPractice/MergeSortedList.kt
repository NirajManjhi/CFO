package leetCodeEasyPractice

import leetCodeLinkedList.ListNode

class MergeSortedList {

    companion object {
        private var node1: ListNode? = null
        private var node2: ListNode? = null

        @JvmStatic
        fun main(args: Array<String>) {
            mergeTwoLists(ListNode.getSortedListHead1(), ListNode.getSortedListHead2())
        }

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            node1 = l1
            node2 = l2
            val dummyHead = ListNode(0)
            var cur: ListNode? = dummyHead
            while (node1 != null || node2 != null) {
                if (node2 == null || (node1 != null && node1?.`val` ?: 0 < node2?.`val` ?: 0)) {
                    cur?.next = node1
                    cur = node1
                    node1 = node1?.next
                } else {
                    cur?.next = node2
                    cur = node2
                    node2 = node2?.next
                }
            }
            return dummyHead.next
        }
    }
}