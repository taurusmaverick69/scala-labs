package lab4

class Table {

  var html: String = "<table><tr>"

  override def toString = html + "</tr></table>"

  def |(col: String) = {
    html = html + "<td>" + col + "</td>"
    this
  }

  def ||(col: String) = {
    html = html + "</tr><tr><td>" + col + "</td>"
    this
  }


}

object Table extends App {

  def apply(): Table = new Table()

  println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET")
}