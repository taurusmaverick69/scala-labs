class Time(val hrs: Int, val min: Int) {

  if (hrs < 0 || hrs > 23 || min < 0 || min > 59)
    throw new IllegalArgumentException("Incorrect data")

  def before(other: Time): Boolean = {
    if (other.hrs == hrs)
      other.min > min
    else
      other.hrs > hrs
  }
}

val time1 = new Time(6, 30)
val time2 = new Time(6, 31)
time1.before(time2)


class Person(var data: String) {
  val firstName = data.split(' ')(0)
  val lastName = data.split(' ')(1)

  override def toString = s"Person($firstName, $lastName)"
}

new Person("Fred Smith")


class Car(manufacturer: String, model: String) {
  var year: Int = -1
  var registrationNo: String = ""

  def this(manufacturer: String, model: String, year: Int, registrationNo: String) {
    this(manufacturer, model)
    this.year = year
    this.registrationNo = registrationNo
  }

  def this(manufacturer: String, model: String, registrationNo: String) {
    this(manufacturer, model)
    this.registrationNo = registrationNo
  }

  def this(manufacturer: String, model: String, year: Int) {
    this(manufacturer, model)
    this.year = year
  }

  override def toString = s"Car($manufacturer, $model, $year, $registrationNo)"
}

object Car {
  def apply(manufacturer: String, model: String): Car = new Car(manufacturer, model)
}

Car("nokia", "mode")

object Color extends Enumeration {


  type Color = Value
  val RED = Value("256")
  val GREEN = Value("")
  val BLUE = Value("")
  val YELLOW = Value("")
  val RED1 = Value("")
  val GREEN2 = Value("")
  val BLUE2 = Value("")
  val YELLOW3 = Value("")

}

Color.RED


class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }

  def getBalance: Double = {
    balance
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {

  override def deposit(amount: Double) = {
    super.deposit(amount)
    super.withdraw(1)
  }

  override def withdraw(amount: Double) = {
    super.withdraw(amount)
    super.withdraw(1)
  }
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance: Double) {

  private var count = 3

  override def deposit(amount: Double) = {
    if (count == 0) {
      super.deposit(amount)
      super.withdraw(1)
    } else {
      count -= 1
      super.deposit(amount)
    }
  }

  override def withdraw(amount: Double) = {
    if (count == 0) {
      super.withdraw(amount)
      super.withdraw(1)
    } else {
      count -= 1
      super.withdraw(amount)
    }
  }

  //sceduled
  def earnMonthlyInterest(): Unit = {
    count = 3
    deposit(getBalance * 10)
  }


  override def toString = s"SavingsAccount(count = $count, balance = $getBalance)"
}


val bankAccount = new BankAccount(100)
bankAccount.deposit(60)
val checkingAccount = new CheckingAccount(100)
checkingAccount.withdraw(60)
checkingAccount.withdraw(10)


val savingsAccount = new SavingsAccount(100)

savingsAccount.deposit(2)
savingsAccount.deposit(2)
savingsAccount.deposit(2)
savingsAccount.deposit(2)
savingsAccount.earnMonthlyInterest()

savingsAccount


abstract class Shape {
  def centerPoint()
}

class Rectangle extends Shape {

  def centerPoint(): Unit = {

  }

}

class Circle extends Shape {

  def centerPoint(): Unit = {

  }
}