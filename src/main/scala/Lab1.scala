import java.util.{Calendar, TimeZone}

import scala.collection.JavaConversions._
import scala.io.Source

object Lab1 {

  def main(args: Array[String]): Unit = {
  }

  private def task1(a: Int): Int = {
    if (a > 0) return 1
    if (a < 0) return -1
    0
  }

  private def task2(str: String): Int = {
    var mul: Int = 1
    for (c <- str.toCharArray) {
      mul *= c.toInt
    }
    mul
  }

  private def task3(str: String): Int = {
    new scala.collection.immutable.StringOps(str).codePoints.reduce(_ * _).getAsInt
  }

  private def task4(): Unit = {
    val arr: Array[Int] = Array(1, 2, 3, 4, 5)
    var i: Int = 0
    while (i < arr.length - 1) {
      val temp: Int = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = temp
      i += 2
    }
    println(arr.deep.mkString)
  }

  private def task7(array: Array[Int]): Array[Int] = {
    array.distinct
  }

  private def task8(): Unit = {
    TimeZone.getAvailableIDs
      .filter((s) => s.startsWith("America/"))
      .map((s) => s.replace("America/", ""))
      .sorted
      .foreach(println(_))
  }

  private def task9(): Unit = {

    val items = Map("OnePlus 5T" -> 500, "Dell Xps 13" -> 1000, "DualShock4" -> 80)
    val itemsWithDiscount = items.transform((_, value) => value * 0.9)
    println(items)
    println(itemsWithDiscount)
  }

  private def task10(): Unit = {
    Map(
      Calendar.MONDAY -> "Monday",
      Calendar.TUESDAY -> "Tuesday",
      Calendar.WEDNESDAY -> "Wednesday",
      Calendar.THURSDAY -> "Thursday",
      Calendar.FRIDAY -> "Friday",
      Calendar.SATURDAY -> "Saturday",
      Calendar.SUNDAY -> "Sunday")
      .toSeq.sortBy(_._1).foreach(println)
  }

  private def task11(fileName: String): Map[String, Int] = {
    Source.fromFile(fileName).getLines.toList.flatMap(_.split(" ")).groupBy(identity).mapValues(_.size)
  }

  private def task12(fileName: String): Unit = {

  }

  private def task13(): Unit = {
    val properties = System.getProperties
    println("\nMAX property is " + properties.stringPropertyNames().maxBy(_.length))
    for ((k, v) <- properties) println(s"key: $k, value: $v")
  }

  private def lteqgt(values: Array[Int], v: Int): Map[String, List[Int]] = {
    values.toList.groupBy {
      case i if i < v => "Less";
      case i if i > v => "More";
      case i if i == v => "Equal";
    }
  }

}