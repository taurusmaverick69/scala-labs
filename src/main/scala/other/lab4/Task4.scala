package other.lab4

class Table(html: String = "<table><tr>") {
  override val toString = html + "</tr></table>"

  def |(col: String) = Table(html + "<td>" + col + "</td>")

  def ||(col: String) = Table(html + "</tr><tr><td>" + col + "</td>")
}

object Table extends App {
  def apply(html: String = "<table><tr>") = new Table(html)

  println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET")
}