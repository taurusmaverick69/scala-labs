Short.MinValue

//2.1. Parsing a Number from a String


def toInt(s: String): Option[Int] = {
  try {
    Some(s.toInt)
  } catch {
    case _: NumberFormatException => None
  }
}
println(toInt("1").getOrElse(0))
println(toInt("a").getOrElse(0))
toInt("tt") match {
  case Some(n) => println(n)
  case None => println("Boom! That wasn't a number.")
}


//2.2. Converting Between Numeric Types (Casting)

val l = 19.75
l.toInt
l.toFloat
l.isValidShort


//2.3. Overriding the Default Numeric Type

val a = 1000L
val a2 = 127: Byte


val a3 = 0x20


// general case
//var [name]:[Type] = [initial value]
// example
var as: Short = 0

class Foo {
  var a: Short = 0
  var b: Short = _ // defaults to 0
}


var name = null.asInstanceOf[Int]