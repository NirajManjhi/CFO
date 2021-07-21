package leetCodeEasyPractice

import leetCodeLinkedList.ListNode

class MidOfLinkedList {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            getMidNode(ListNode.getSimpleLinkedListHead())
        }

        fun getMidNode(h: ListNode?): ListNode? {
            var head = h
            var midPrev: ListNode? = null
            while (head?.next != null) {
                midPrev = if (midPrev == null) {
                    head
                } else {
                    midPrev.next
                }
                head = head.next?.next
            }
            return midPrev?.next
        }
    }
}