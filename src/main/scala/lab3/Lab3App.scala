package lab3


import scala.collection.mutable.ArrayBuffer


object Lab3App extends App {


  def taskPrinter(num: Int) = {
    println("\n==================")
    println("Task" + num)
    println("==================")
  }

  //1.
  taskPrinter(1)
  var tuple = (0, 1)
  println("Original tuple:")
  print(tuple._1)
  print(tuple._2)


  def swap[T, V](item: Tuple2[T, V]): Tuple2[V, T] = {
    val revert = item match {
      case (v, k) => (k, v)
    }

    revert
  }

  var revert = swap(tuple)
  println("\nReverted tuple:")
  print(revert._1)
  print(revert._2)
  println()

  //  def swapFirstTwo[T](array: Array[T]) = {
  //    (array match {
  //      case x Array(a, b, _*) => {
  //        Array(b, a, x)
  //      }
  //    })
  //  }
  //
  //  //2.
  //  taskPrinter(2)
  //  var array = Array(1, 2, 3, 4, 5)
  //
  //  println("Original array")
  //  println(array.mkString(" "))
  //
  //  println("Modified array")
  //  println(swapFirstTwo(array).asInstanceOf[Array[Int]].mkString(" "))


  def leafSum(list: List[Any]): Int = {
    var localCounter = 0
    for (item <- list) {
      item match {
        case x: Int => localCounter += x
        case l: List[Any] => localCounter += leafSum(l)
      }
    }

    localCounter
  }

  //3.
  taskPrinter(3)
  var tree: List[Any] = (List(3, 8), 2, List(5)).productIterator.toList
  println("Leaf sum: ")
  print(leafSum(tree))


  def nodeLeafSum(tree: BinaryTree): Int = {
    var localCounter = 0
    tree match {
      case Leaf(l) => localCounter += l
      case n: Node => {
        localCounter += nodeLeafSum(n.left)
        localCounter += nodeLeafSum(n.right)
      }
    }
    localCounter
  }


  //4.
  taskPrinter(4)

  var nodeTree = Node(Node(Leaf(3), Leaf(8)), Leaf(2))
  println("Node leaf sum: ")
  print(nodeLeafSum(nodeTree))


  def multiNodeLeafSum(tree: BinaryTree): Int = {
    var localCounter = 0
    tree match {
      case Leaf(l) => localCounter += l
      case n: Node => {
        localCounter += multiNodeLeafSum(n.left)
        localCounter += multiNodeLeafSum(n.right)
      }
      case m: MultiNode => {
        for (item <- m.leafs) {
          localCounter += multiNodeLeafSum(item)
        }
      }
      case _ => {}
    }
    localCounter
  }

  //5.
  taskPrinter(5)

  var multiNodeTree = MultiNode(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5), null))
  println("Multi node leaf sum: ")
  print(multiNodeLeafSum(multiNodeTree))


  //6.
  taskPrinter(6)

  def evalElement(item: BinaryTreeWithOperator): Int = {

    val valuesListBuffer = new ArrayBuffer[Int]()
    var values: List[Int] = List()

    //get list of operands
    item match {
      case Leaf(l) => l
      case n: NodeWithOperator => {
        if (n.left != null) {
          var x = evalElement(n.left)
          //  println("left node eval: " + x)
          valuesListBuffer += x
        }
        if (n.right != null) {
          var x = evalElement(n.right)
          //  println("right node eval: " + x)
          valuesListBuffer += x
        }
      }
      case m: MultiNodeWithOperator => {
        for (i <- m.leafs) {
          var x = evalElement(i)
          //  println("item eval of " + i + ": " + x)
          valuesListBuffer += evalElement(i)
        }
      }
    }

    values = valuesListBuffer.toList

    //apply operator

    var result = 0
    item.operator match {
      case "+" => {
        for (i <- values) {
          //  println(result + " add " + i)
          result += i
          //  println("a res: " + result)
        }
      }
      case "-" => {
        if (values.length == 1) {
          -values(0)
        }
        result = values(0)
        for (i <- values.drop(1)) {
          //  println(result + " sub " + i)
          result -= i
          //  println("s res: " + result)
        }
      }
      case "/" => {
        result = values(0)
        for (i <- values.drop(1)) {
          // println(result + " div " + i)
          result /= i
          // println("d res: " + result)
        }
      }
      case "*" => {
        result = values(0)
        for (i <- values.drop(1)) {
          // println(result + " mul " + i)
          result *= i
          // println("m res: " + result)
        }
      }

    }
    result
  }


  var multiNodeTreeWithOperators = MultiNodeWithOperator("+",
    NodeWithOperator(Leaf(3), Leaf(8), "*"),
    Leaf(2),
    NodeWithOperator(Leaf(5), null, "-"))
  println("Multi node w/ operators leaf sum: ")
  print(evalElement(multiNodeTreeWithOperators))


  //7.
  taskPrinter(7)

  val pair1 = new lab3.Pair(1, "One")
  println("Original pair:")
  println(pair1.first.getClass + " : " + pair1.first + " | " + pair1.second.getClass + " : " + pair1.second)


  val pair2: lab3.Pair[String, Int] = pair1.swap()
  println("Swapped pair:")
  println(pair2.first.getClass + " : " + pair2.first + " | " + pair2.second.getClass + " : " + pair2.second)


  //8.
  taskPrinter(8)

  val pair3 = new lab3.PairMutable(1, 2)
  println("Original pair:")
  println(pair3.first + " | " + pair3.second)


  val pair4: lab3.PairMutable[Int] = pair3.swapMutable()
  println("Swapped pair:")
  println(pair4.first.getClass + " : " + pair4.first + " | " + pair4.second.getClass + " : " + pair2.second)


  //9.
  taskPrinter(9)

  var x = (5, "Five")
  println(x._1 + " " + x._2)

  var z = lab3.Pair.swapTuple(x)
  println(z._1 + " " + z._2)


  //10.

  def middle[T](collection: Iterable[T]): String = {
    val indexedSeq = collection.toIndexedSeq
    indexedSeq.length % 2 match {
      case 0 => {
        indexedSeq(indexedSeq.length / 2 - 1).toString + indexedSeq(indexedSeq.length / 2).toString
      }
      case _ => {
        indexedSeq((indexedSeq.length - 1) / 2).toString
      }
    }
  }


  taskPrinter(10)

  val worldString = "World!"

  println(worldString)
  println(middle(worldString))


  //11.

  taskPrinter(11)


  var intPair = new lab3.Pair[Int, Int](1, 2)
  println("Original")
  println(intPair.first + " " + intPair.second)


  var newPair = lab3.Pair.strictSwap[Int, Int](3, 4)
  println("Modified")
  println(newPair.first + " " + newPair.second)

}