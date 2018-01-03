package lab4

class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

  override def toString = num + "/" + den

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  def /(other: Fraction) = new Fraction(num * other.den, den * other.num)

  def +(other: Fraction) = new Fraction((num * other.den) + (den * other.num), den * other.den)

  def -(other: Fraction) = new Fraction((num * other.den) - (den * other.num), den * other.den)

  def unary_=(frac: String) = {
    val strings = frac.split(" ")
    new Fraction(strings(0).toInt, strings(1).toInt)
  }
}

object Fraction extends App {


  def apply(frac: String) = {
    val strings = frac.split(" ")
    new Fraction(strings(0).toInt, strings(1).toInt)
  }

//  var f: Fraction = "15 6"
  //  f.=:("15 6")

  //  val x = new Fraction(2, 4)
  //  val y = new Fraction(3, 2)
  //
  //  private val fraction = new Fraction(15, 6)
  //
  //  println(fraction)
  //  println(x + y)
  //  println(x - y)
  //  println(x * y)
  //  println(x / y)
  //


}