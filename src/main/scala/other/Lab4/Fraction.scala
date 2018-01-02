package other.Lab4

import scala.math._

class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

  override def toString = num + "/" + den

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def normalize(): Fraction = {
    val gcdVal = gcd(num, den);
    if (gcdVal > 1) {
      new Fraction(num / gcdVal, den / gcdVal)
    }
    this
  }

  def +(f: Fraction): Fraction = {
    val gcdVal = gcd(this.den, f.den)

    new Fraction(max(this.num, f.num) + min(this.num, f.num) * gcdVal, max(this.den, f.den))
  }

  def -(f: Fraction): Fraction = {
    val gcdVal = gcd(this.den, f.den)
    new Fraction(if (d < this.den) this.num * gcdVal else this.num - f.num, max(this.den, f.den))
  }

  def *(f: Fraction): Fraction = {
    new Fraction(this.num * f.num, this.den * f.den)
  }

  def /(f: Fraction): Fraction = {
    new Fraction(this.num * f.den, this.den * f.num)
  }

}
