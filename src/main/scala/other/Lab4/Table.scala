package other.Lab4

import scala.collection.mutable.ArrayBuffer

class Table {


  private val rowBuilder = new ArrayBuffer[Array[String]]
  private val columnBuilder = new ArrayBuffer[String]

  def |(td: String): Table = {
    columnBuilder += td
    this
  }

  def ||(td: String): Table = {
    rowBuilder += columnBuilder.toArray
    columnBuilder.clear()
    columnBuilder += td
    this
  }

  override def toString: String = {
    val sb = new StringBuilder()
    sb.append("<table>")

    for (tr <- (rowBuilder += columnBuilder.toArray) toArray) {
      sb.append("<tr>")
      for (td <- tr) {
        sb.append("<td>")
        sb.append(td)
        sb.append("</td>")
      }
      sb.append("</tr>")
    }
    sb.append("</table>")
    sb.toString()
  }
}

