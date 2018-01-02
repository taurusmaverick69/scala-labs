package other.lab4

class Matrix(val m: Int, val n: Int) {

  private val value = Array.ofDim[Double](m, n) // многомерный массив

  def update(x: Int, y: Int, v: Double) = value(x)(y) = v

  def apply(x: Int, y: Int) = value(x)(y)

  def +(other: Matrix) = {
    if (m != other.m || n != other.n)
      throw new Exception("Rows or cols don't match.")

    var res = new Matrix(m, n)
    for (i <- 0 until m; j <- 0 until n) {
      res(i, j) = this.value(i)(j) + other.value(i)(j)
    }
    res
  }

  def *(factor: Double) = {
    var res = new Matrix(m, n)
    for (i <- 0 until m; j <- 0 until n) {
      res(i, j) = this.value(i)(j) * factor
    }
    res
  }

  def *(other: Matrix) = {
    require(n == other.m)
    var res = new Matrix(m, n)
    for (i <- 0 until m; j <- 0 until n) {
      res(i, j) = (for (k <- 0 until n) yield value(i)(k) * other.value(k)(j)).sum
    }
    res
  }

  override def toString = value.map(_.mkString(" ")).mkString("\n")
}

object Matrix extends App {
  val x = new Matrix(2, 2)
  x(0, 0) = 1
  x(0, 1) = 2
  x(1, 0) = 3
  x(1, 1) = 4

  println("Исходная матрица")
  println(x)
  println("Умножение на скаляр")
  println(x * 2)
  println("Умножение двух матриц")
  println(x * x)
  println("Сумма двух матриц")
  println(x + x)

}