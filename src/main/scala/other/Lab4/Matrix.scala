package other.Lab4

class Matrix(val m: Int, val n: Int) {

  var matrix: Array[Array[Int]] = new Array[Array[Int]](0)


  def this(array: Array[Array[Int]]) {
    this(array.length, array(0).length)
    matrix = array
  }

  def mat(row: Int, col: Int): Int = {
    matrix(row)(col)
  }

  def +(mtx: Matrix): Matrix = {
    if (mtx.m != n || mtx.n != n) {
      return null
    }

    var i, j = 0
    for (i <- 0 to m - 1) {
      for (j <- 0 to n - 1) {
        matrix(i)(j) += mtx.mat(i, j)
      }
    }
    this
  }

  def *(mtx: Matrix): Matrix = {
    if (mtx.m != n) {
      return null
    }
    val matrixArray = new Array[Array[Int]](m)

    for (i <- 0 to m - 1) {
      for (j <- 0 to mtx.n - 1) {
        matrixArray(i) = new Array[Int](mtx.n)
        for (z <- 0 to n - 1) {
          matrixArray(i)(j) += mat(i, z) * mtx.mat(z, j)
        }
      }
    }
    new Matrix(matrixArray)
  }

}
