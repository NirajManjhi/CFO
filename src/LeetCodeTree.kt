import java.util.*
import kotlin.collections.ArrayList


object LeetCodeTree {

    private val ret: MutableList<String> = mutableListOf()
    private var depth = 0

    @JvmStatic
    fun main(args: Array<String>) {
//        inOrderTraversal(getData())
//        val result = inOrderTraversalRecursive(getData())
//        preorderTraversal(getData())
//        val result = preorderTraversalRecursive(getData())
//        postOrderTraversal(getData())
//        val result = postOrderTraversalRecursive(getData())
//        result.forEach {
//            print("$it, ")
//        }
//        levelOrder(getData())
//        maxDepth(root = getData(), tempDepth = 1)
//        print(depth)
//        print(maxDepth(getData()))
//        print(isSymmetric(getSymmetricTree()))
//        print(hasPathSum(getIntTreeData(), 8))
        val inorder = intArrayOf(9, 3, 15, 20, 7)
        val postorder = intArrayOf(9, 15, 7, 20, 3)
        val preorder = intArrayOf(3,9,20,15,7)
//        val tree = buildTree(inorder, postorder)
//        val tree = buildTree2(preorder, inorder)
//        println(tree.toString())
    }

    private var rootIndex = 0

    private fun buildTree2(preorder: IntArray, inorder: IntArray): TreeNodeInt? {
        return build(preorder = preorder, inorder = inorder)
    }

    private fun build(preorder: IntArray, inorder: IntArray, preIndex: Int = 0, inIndex: Int = 0, size: Int = preorder.size): TreeNodeInt? {
        return if (size <= 0) null else {
            val splitAt = inorder.indexOfFirst { it == preorder[preIndex] }
            val leftSize = splitAt - inIndex
            val node = TreeNodeInt(preorder[preIndex])
            node.left = build(preorder, inorder, preIndex + 1, inIndex, leftSize)
            node.right = build(preorder, inorder, preIndex + leftSize + 1, splitAt + 1, size - leftSize - 1)
            node
        }
    }

    private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNodeInt? {
        rootIndex = postorder.lastIndex
        return build(inorder, postorder, 0, rootIndex)
    }

    private fun build(inorder: IntArray, postorder: IntArray, from: Int, to: Int): TreeNodeInt? {
        if (from > to) return null // from & to in inorder.
        val rootValue = postorder[rootIndex--]
        val rootIndexInorder = inorder.indexOf(rootValue) // can use hashset to get faster results
        val root = TreeNodeInt(rootValue)
        if (from == to) return root // eager return
        root.right = build(inorder, postorder, rootIndexInorder + 1, to)
        root.left = build(inorder, postorder, from, rootIndexInorder - 1)
        return root
    }

    private fun hasPathSum(root: TreeNodeInt?, sum: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.left == null && root.right == null) {
            return sum - root.value == 0
        }
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
    }

    private fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isSubtreeSymmetric(root.left, root.rightNode)
    }

    private fun isSubtreeSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }

        if (left?.value != right?.value) {
            return false
        }

        return isSubtreeSymmetric(left?.left, right?.rightNode) && isSubtreeSymmetric(left?.rightNode, right?.left)
    }

    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val left = maxDepth(root.left) + 1
        val right = maxDepth(root.rightNode) + 1

        return Math.max(left, right)
    }

    private fun maxDepth(root: TreeNode?, tempDepth: Int) {
        if (root == null) {
            return
        }
        if (root.left == null && root.rightNode == null) {
            depth = Math.max(depth, tempDepth)
        }
        maxDepth(root.left, tempDepth + 1)
        maxDepth(root.rightNode, tempDepth + 1)
    }

    private fun levelOrder(root: TreeNode?): List<List<String>> {
        val result = ArrayList<ArrayList<String>>()
        val q: Queue<TreeNode> = LinkedList()

        if (root != null) {
            q.add(root)
        }

        while (q.isNotEmpty()) {
            val level = ArrayList<String>()
            for (i in q.indices) {
                val node = q.poll()
                level.add(node.value)

                if (node.left != null) {
                    q.add(node.left)
                }
                if (node.rightNode != null) {
                    q.add(node.rightNode)
                }
            }
            result.add(level)
        }
        result.forEach {
            print("$it, ")
        }
        return result
    }

    /*private fun levelOrder(root: TreeNode?): List<List<String>> {
        val result = ArrayList<ArrayList<String>>()
        val listOfRoot = arrayListOf(root)
        val tempListOfRoot = arrayListOf(root)

        while (listOfRoot.isNotEmpty()) {
            val tempResult = arrayListOf<String>()

            tempListOfRoot.forEach { tempRoot ->
                if (tempRoot != null) {
                    tempResult.add(tempRoot.value)
                }
                tempRoot?.left?.let {
                    listOfRoot.add(it)
                }
                tempRoot?.rightNode?.let {
                    listOfRoot.add(it)
                }
                listOfRoot.remove(tempRoot)
            }
            tempListOfRoot.clear()
            tempListOfRoot.addAll(listOfRoot)
            result.add(tempResult)
        }
        result.forEach {
            print("$it, ")
        }
        return result
    }*/

    private fun inOrderTraversal(root: TreeNode?): List<String> {
        val result = ArrayList<String>()
        val stack = Stack<TreeNode>()
        var curr = root
        while (curr != null || stack.isNotEmpty()) {
            if (curr != null) {
                stack.push(curr)
                curr = curr.left
                continue
            }
            val node = stack.pop()
            result.add(node.value)
            curr = node.rightNode
        }
        result.forEach {
            print("$it, ")
        }
        println()
        return result
    }

    private fun inOrderTraversalRecursive(root: TreeNode?): List<String> {
        if (root == null) {
            return ret
        }
        inOrderTraversalRecursive(root.left)
        ret.add(root.value)
        inOrderTraversalRecursive(root.rightNode)
        return ret
    }

    private fun preorderTraversal(root: TreeNode?): List<String>? {
        var cur = root
        val result = ArrayList<String>()
        val stack = Stack<TreeNode>()
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.value)
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.pop().rightNode
        }
        result.forEach {
            print("$it, ")
        }
        println()
        return result
    }

    private fun preorderTraversalRecursive(root: TreeNode?): List<String> {
        if (root == null) {
            return ret
        }
        ret.add(root.value)
        preorderTraversalRecursive(root.left)
        preorderTraversalRecursive(root.rightNode)
        return ret
    }

    private fun postOrderTraversal(root: TreeNode?): List<String?>? {
        var cur = root
        val result = ArrayList<String>()
        val stack = Stack<TreeNode>()
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.value)
                stack.push(cur)
                cur = cur.rightNode
            }
            cur = stack.pop().left
        }
        result.reverse()
        result.forEach {
            print("$it, ")
        }
        println()
        return result
    }

    private fun postOrderTraversalRecursive(root: TreeNode?): List<String> {
        if (root == null) {
            return ret
        }
        postOrderTraversalRecursive(root.left)
        postOrderTraversalRecursive(root.rightNode)
        ret.add(root.value)
        return ret
    }
}