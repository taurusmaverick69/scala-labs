package lab4

import java.io._

trait BufferedInput extends InputStream {

  private val istream = new BufferedInputStream(this) //Класс BufferedInputStream накапливает вводимые данные в специальном буфере без постоянного обращения к устройству ввода

  override def read = istream.read
}

object Task1_4 extends App {
  val fin = new FileInputStream("D:\\task1_lb4.txt") with BufferedInput
  var data: Int = -2
  while (data != -1) {
    if (data >= 0)
      print(data.toChar)
    data = fin.read
  }
}