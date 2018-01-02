package other.lab4

import scala.collection.mutable

object Task8 extends App {
  def indexes(s: String) = {
    var result = mutable.SortedMap[Char, mutable.Set[Int]]()

    for ((c, index) <- s.zipWithIndex)
      result.getOrElseUpdate(c, mutable.SortedSet[Int]()) += index
    result
  }

  val word = indexes("Mississippi")
  for ((k, v) <- word) {
    println(k + ":" + v.mkString("{", ", ", "}"))
  }
}