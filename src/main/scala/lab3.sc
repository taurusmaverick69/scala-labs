def swap1(tuple2: (Int, Int)) = {
  tuple2 match {
    case (a, b) => (a, b).swap
  }
}
swap1(6, 5)

def swap2(array: Array[Int]) = {
  array.length match {
    case 1 => array
    case _ =>
      val temp = array(0)
      array(0) = array(1)
      array(1) = temp
      array
  }
}
swap2(Array(1, 2, 3, 4))


final class Pair[T, S] {
  def swap(t: T, s: S) = {
    (t, s).swap
  }
}

new Pair[Double, Int].swap(3.0, 9)
