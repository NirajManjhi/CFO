package leetCodeLinkedList

object LinkedListHandsOn {

    @JvmStatic
    fun main(args: Array<String>) {
//        print(hasCycle(ListNode.getHeadOfCircularList()))
        print(detectCycle(ListNode.getHeadOfCircularList()))
    }

    private fun hasCycle(head: ListNode?) : Boolean {
        if (head?.next == null) {
            return false
        }
        var slowPtr = head
        var fastPtr = head
        while (slowPtr?.next != null && fastPtr?.next?.next != null) {
            slowPtr = slowPtr.next
            fastPtr = fastPtr.next?.next
            if (slowPtr == fastPtr) {
                return true
            }
        }
        return false
    }

    private fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while(slow?.next != null && fast != null) {
            slow = slow.next
            fast = fast.next?.next
            if(slow == fast) {
                slow = head
                while(slow != fast) {
                    slow = slow?.next
                    fast = fast?.next
                }
                return fast
            }
        }
        return null
    }
}