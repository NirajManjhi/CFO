import kotlin.reflect.jvm.internal.impl.utils.DFS

class TreeNode(var value: String, var left: TreeNode? = null, var rightNode: TreeNode? = null)
class TreeNodeInt(var value: Int, var left: TreeNodeInt? = null, var right: TreeNodeInt? = null)
class Node(var value: Int, var neighbors: List<Node>? = null)

fun getData(): TreeNode {
    return TreeNode(value = "F",
            left = TreeNode(value = "B",
                    left = TreeNode(value = "A"),
                    rightNode = TreeNode(value = "D",
                            left = TreeNode(value = "C"),
                            rightNode = TreeNode(value = "E"))),
            rightNode = TreeNode(value = "G",
                    rightNode = TreeNode(value = "I",
                            left = TreeNode(value = "H", left = TreeNode(value = "M")),
                            rightNode = TreeNode(value = "J"))))
}

fun getSymmetricTree(): TreeNode {
    return TreeNode(value = "F",
            left = TreeNode(value = "B",
                    left = TreeNode(value = "A"),
                    rightNode = TreeNode(value = "D")),
            rightNode = TreeNode(value = "B",
                    left = TreeNode(value = "D"),
                    rightNode = TreeNode(value = "A")))
}

fun getIntTreeData(): TreeNodeInt {
    return TreeNodeInt(value = 1,
            left = TreeNodeInt(value = 2,
                    left = TreeNodeInt(value = 3),
                    right = TreeNodeInt(value = 4)),
            right = TreeNodeInt(value = 5))
}

fun getNodesTree(): Node {
    return Node(value = 1, neighbors = listOf(
            Node(value = 2, neighbors = listOf(
                    Node(value = 5))),
            Node(value = 3, neighbors = listOf(
                    Node(value = 5),
                    Node(value = 6, neighbors = listOf(
                            Node(value = 7))))),
            Node(value = 4, neighbors = listOf(
                    Node(value = 7)))))
}

fun getOneNode(): Node {
    return Node(value = 7)
}