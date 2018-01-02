package other.lab3

sealed abstract class BinaryTree

sealed case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

sealed case class MultiNode(leafs: BinaryTree*) extends BinaryTree

sealed case class NewClass() extends BinaryTree


sealed abstract class BinaryTreeWithOperator(val operator: String) extends BinaryTree {
  //def operator = op
}

sealed case class Leaf(value: Int) extends BinaryTreeWithOperator("")

sealed case class NodeWithOperator(left: BinaryTreeWithOperator, right: BinaryTreeWithOperator, op: String) extends BinaryTreeWithOperator(op)

sealed case class MultiNodeWithOperator(op: String, leafs: BinaryTreeWithOperator*) extends BinaryTreeWithOperator(op)
