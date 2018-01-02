package other.lab3

object Pair {
  def swapTuple[T, V](tuple: (T, V)): (V, T) = {
    (tuple._2, tuple._1)
  }

  def strictSwap[T, V](f: T, s: V)(implicit ev: T =:= V): Pair[V, T] = {
    new Pair[V, T](s, f)
  }
}


class Pair[T, V](val first: T, val second: V) {


  def swap(): Pair[V, T] = {
    new Pair[V, T](second, first)
  }
}

class PairMutable[T](var first: T, var second: T) {
  def swapMutable(): PairMutable[T] = {
    val temp = first
    first = second
    second = temp
    this
  }
}