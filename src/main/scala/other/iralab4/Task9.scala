package other.iralab4

class Task9 {
  def removeNull(lst: List[Int]): List[Int] = {
    lst.filter(_ != 0)
  }

}

object Task9 extends App {
  var list = new Task9
  println(list.removeNull(List(5, 0, 0, 3, 2)))
}