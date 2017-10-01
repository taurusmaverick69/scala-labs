import java.util.TimeZone
import javax.lang.model.`type`.ArrayType

object Main extends App {
  print("hello-world")


  //VARIABLES
  val a = 1
  println(a.getClass)

  var b: Double = 1
  println(b.getClass)

  b = 3
  // val -> final in Java
  // var -> variable

  //In scala no primitives/objects (int-Integer), only Int, Double

  1 + 2 //plus is method
  //or
  1.+(2)


  //FUNCTIONS
  //no need to return, no need to set type of return value
  def add(a: Int, b: Int) = a + b

  def x2(a: Int) = {
    println("THis is multiple by 2")
    a * 2
  }

  //Unit like void
  def myPrint(str: String): Unit = println(str)

  println(x2(3))
  myPrint("TEST")


  //Almost all is condition
  val d = if (a > 0) 1 else -1
  println(d)

  def printer(value: String): Unit = println(s"I am writing: $value")

  printer({
    (26 + 3).toString
  })


  //Каррироване
  def sum(a: Int)(b: Double) = a + b

  val doubleToDouble: (Double) => Double = sum(6)
  println(doubleToDouble(12))

  def sum(a: Int, b: Int) = a + b

  val intToInt: (Int) => Int = sum(_, 10)
  println(intToInt(30))


  TimeZone.getAvailableIDs()
    .filter((s) => s.startsWith("America/"))
    .map((s) => s.replace("America/", ""))
    .sorted()
    .forEach((s) => println(s))



//  val test: String = "Mississippi"
//  test
//    .chars()
//    .boxed()
//    .map((c) => c.intValue().toChar)


}