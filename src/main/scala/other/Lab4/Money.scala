package other.Lab4

class Money(val dollars: Int, val cents: Int) {

  override def toString = dollars + "." + cents + "$"

  def +(m: Money): Money = {
    new Money(dollars + m.dollars + (if (cents + m.cents > 100) 1 else 0), (cents + m.cents) % 100)
  }

  def -(m: Money): Money = {
    new Money(dollars - m.dollars - (if (cents < m.cents) 1 else 0), if (cents > m.cents) cents - m.cents else 100 - (m.cents - cents))
  }

  def ==(m: Money): Boolean = {
    dollars == m.dollars && cents == m.cents
  }

  def <(m: Money): Boolean = {
    dollars * 100 + cents < m.dollars * 100 + m.cents
  }


}
