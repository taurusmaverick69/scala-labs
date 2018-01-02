package other.Lab4

import scala.collection.mutable


object Lab4App extends App {
  //    1)	В библиотеке java.io имеется возможность добавить
  //      буферизацию в поток ввода с помощью декоратора BufferedInputStream .
  //    Реализуйте буферизацию как трейт. Для простоты переопределите метод read


  def taskPrinter(num: Int): Unit = {
    println("\n==================")
    println("Task" + num)
    println("==================")
  }

  //1.
  taskPrinter(1)

  //    val text = "Hello world!"
  //    val buffer = text.getBytes
  //    val in = new ByteArrayInputStream(buffer)
  //
  //
  //   var x = new Buffer(in) with Bufferable
  //
  //
  //    for (b <- x.read()) {
  //      System.out.print(b)
  //    }


  //2.
  taskPrinter(2)
  val a = new Fraction(1, 2)
  val b = new Fraction(3, 4)

  println(a + b)

  println(b - a)

  println(a * b)

  println(b / a)

  //3.
  taskPrinter(3)

  val m1 = new Money(2, 30)
  val m2 = new Money(1, 50)

  println(m1 + m2)
  println(m1 - m2)
  println(m1 == m2)
  println(m1 < m2)
  println(m2 < m1)

  //4.
  taskPrinter(4)

  var table = new Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"

  println(table)

  //5.
  taskPrinter(5)


  var matrixOne = new Matrix(Array[Array[Int]](Array[Int](1, 1), Array[Int](1, 1)))
  var matrixTwo = new Matrix(Array[Array[Int]](Array[Int](2, 2), Array[Int](2, 2)))


  matrixOne + matrixTwo


  var matrixThree = new Matrix(Array[Array[Int]](Array[Int](4, 2), Array[Int](9, 0)))
  var matrixFour = new Matrix(Array[Array[Int]](Array[Int](3, 1), Array[Int](-3, 4)))


  var newMatrix = matrixThree * matrixFour

  //6.
  taskPrinter(6)

  def values(fun: (Int) => Int, low: Int, high: Int): Iterable[(Int, Int)] = {
    for (i <- low to high)
      yield (i, fun(i))
  }

  println(values(x => x * x, -5, 5).mkString(" "))

  //7.
  taskPrinter(7)

  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    var maxVal: Int = fun(inputs(0))
    inputs.drop(1).foreach(i => {
      val value: Int = fun(i)
      if (value > maxVal) maxVal = value
    })
    maxVal
  }

  println(largest(x => 10 * x - x * x, 1 to 10))


  def indexes(s: String): Iterable[(Char, mutable.Set[Int])] = {
    (for (c <- s)
      yield {
        val set = new mutable.HashSet[Int]()
        var index = 0
        do {
          index = s.indexOf(c, index)
          if (index >= 0) set.add(index)
          index += 1
        } while (index > 0)

        (c, set)
      }).distinct
  }


  //8.
  taskPrinter(8)

  var res = indexes("Missisippi")
  println(res.mkString(" | "))
  println()

  //9.
  taskPrinter(9)

  var linkedList = mutable.LinkedList[Int](0, 1, 2, 3, 0, 5)

  println(linkedList.filter(x => x != 0).mkString(" "))

}

