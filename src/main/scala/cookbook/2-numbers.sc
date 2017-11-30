import scala.util.Random

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



//2.4. Replacements for ++ and −−
var ai = 1
ai += 1
ai



//2.5. Comparing Floating-Point Numbers
val b = 0.1 + 0.2



//2.6. Handling Very Large Numbers
var b1 = BigInt(1234567890)
var b2 = BigDecimal(1234567890)

b1 + b1
b1.isValidInt

Double.PositiveInfinity
Double.NegativeInfinity



//2.7. Generating Random Numbers

val r = Random
r.nextInt
r.nextInt(100) //0 to 99
r.nextDouble

val r1 = new Random(100)

r.nextPrintableChar

0 to r.nextInt(10) toList


//2.8. Creating a Range, List, or Array of Numbers

val r2 = 1 to 10 size
val r3 = 1 to 10 by 3

for (i <- 1 to 5) println(i)
for (i <- 1 until 5) println(i)


val x = 1 to 10 toList


//2.9. Formatting Numbers and Currency

val pi = scala.math.Pi
println(f"$pi%1.5f")
