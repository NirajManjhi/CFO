package leetCodeLinkedList

data class ListNode(var `val` : Int?) {
    var next: ListNode? = null

    companion object {
        fun getHeadOfCircularList(): ListNode {
            val head = ListNode(3)
            val circularHead = ListNode(5)
            head.next = ListNode(2)
            head.next?.next = circularHead
            head.next?.next?.next = ListNode(-4)
            head.next?.next?.next?.next = ListNode(7)
            head.next?.next?.next?.next?.next = ListNode(8)
            head.next?.next?.next?.next?.next?.next = ListNode(9)
            head.next?.next?.next?.next?.next?.next?.next = circularHead
            return head
        }

        fun getSimpleLinkedListHead() : ListNode {
            val h = ListNode(7)
            h.next = ListNode(9)
            h.next?.next = ListNode(2)
            h.next?.next?.next = ListNode(10)
            h.next?.next?.next?.next = ListNode(1)
            h.next?.next?.next?.next?.next = ListNode(8)
            h.next?.next?.next?.next?.next?.next = ListNode(6)
            return h
        }

        fun getSortedListHead1() : ListNode {
            val h = ListNode(1)
            h.next = ListNode(1)
            h.next?.next = ListNode(2)
            h.next?.next?.next = ListNode(5)
            return h
        }

        fun getSortedListHead2() : ListNode {
            val h = ListNode(1)
            h.next = ListNode(3)
            h.next?.next = ListNode(6)
            h.next?.next?.next = ListNode(9)
            return h
        }
    }
}