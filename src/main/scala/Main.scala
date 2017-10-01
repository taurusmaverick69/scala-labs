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






}


