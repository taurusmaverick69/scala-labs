import java.util.TimeZone

object Lab1 extends App {

  test()

  private def test(): Unit = {
    TimeZone.getAvailableIDs
      .filter((s) => s.startsWith("America/"))
      .map((s) => s.replace("America/", ""))
      .sorted
      .foreach(println(_))
  }
}
