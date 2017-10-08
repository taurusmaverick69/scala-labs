val arr: Array[Int] = Array(1, 2, 3, 4, 5)

for (i <- 0 until arr.length - 1 by 2) {
  val temp: Int = arr(i)
  arr(i) = arr(i + 1)
  arr(i + 1) = temp
}