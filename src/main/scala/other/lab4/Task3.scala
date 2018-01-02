package other.lab4

class Money(d: Int, c: Int) {
  val dollar: Int = if (c < 99) d else d + c / 100;
  val cent: Int = c % 100;

  override def toString = dollar + "," + cent

  def toCent(): Int = dollar * 100 + cent

  def +(other: Money) = new Money((toCent + other.toCent) / 100, (toCent + other.toCent) % 100)

  def -(other: Money) = new Money((toCent - other.toCent) / 100, (toCent - other.toCent) % 100)

  def ==[T](other: T)(implicit ev: T <:< Money) = {
    toCent == other.asInstanceOf[Money].toCent
  }

  def <(other: Money) = toCent < other.toCent

  def >(other: Money) = toCent > other.toCent
}


object Money extends App {
  def apply(dollar: Int, cent: Int) = new Money(dollar, cent)

  println(new Money(1, 75) + new Money(0, 50) == new Money(3, 25))
  println(new Money(1, 25) - new Money(0, 50) == new Money(0, 75))
  println(Money(1, 25) > Money(0, 75))
  println(Money(1, 25) < Money(0, 75))

}