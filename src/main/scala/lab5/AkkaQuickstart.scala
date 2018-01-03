//#full-example
package lab5

import java.awt.Color
import java.awt.image._
import java.io.{ByteArrayOutputStream, File, FileInputStream}
import java.nio.file.Files
import javax.imageio.ImageIO

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import lab5.ResultActor.Attached

import scala.concurrent.duration._
import scala.util.Random
import scala.util.matching.Regex
import scala.util.matching.Regex.MatchIterator

class Stopwatch {
  var startedAtNanos = System.nanoTime()

  def elapsed(): Duration = {
    (System.nanoTime() - startedAtNanos).nanos
  }

  def reset(): Unit = {
    startedAtNanos = System.nanoTime()
  }
}

object Stopwatch {
  def start(): Stopwatch = new Stopwatch
}

object ResultActor {
  def props(): Props = Props[ResultActor]

  case object Attached

}

class ResultActor extends Actor {

  var total: Int = 0
  var count: Int = 0
  var attachedCount: Int = 0

  override def receive = {
    case x: (Int, Int) =>
      total += x._1
      count += x._2
      attachedCount -= 1
      if (attachedCount == 0) {
        println("Mean value of array:" + total / count)
        println("Completed")
      }
    case Attached =>
      attachedCount += 1
  }
}

class CalculatorActor(resultActor: ActorRef) extends Actor() {
  var sum: Int = 0
  resultActor ! Attached

  override def receive = {
    case a: Seq[Int] => {
      a.foreach(sum += _)
      resultActor ! (sum, a.length)
    }
  }
}

object Calculator {
  def props(resultActor: ActorRef): Props = Props(new CalculatorActor(resultActor))
}

class InverterActor() extends Actor() {
  var from: Int = 0
  var filename: String = ""
  var to: Int = 0


  override def receive = {

//    case x: (Int, Int) => from = x._1 = x._2
    case s: String => filename = s
    case img: BufferedImage => {

      var w = img.getWidth() - 1
      for (x <- 0 to w) {
        for (y <- from to to) {
          val rgba: Int = img.getRGB(x, y)
          var col: Color = new Color(rgba, true)
          col = new Color(255 - col.getRed,
            255 - col.getGreen,
            255 - col.getBlue)
          img.setRGB(x, y, col.getRGB)
        }
      }


      val baos = new ByteArrayOutputStream
      ImageIO.write(img, "jpg", baos)
      baos.flush()
      val imageInByte = baos.toByteArray

      Files.write(new File(filename).toPath, imageInByte)

    }
  }
}

object InverterActor {
  def props(): Props = Props[InverterActor]
}

class RegexActor(actorSystem: ActorSystem, resultActor: ActorRef) extends Actor() {
  var regex: Regex = null

  override def receive = {
    case r: Regex => regex = r
    case s: String => startSearch(s)
    case (p: String, m: MatchIterator) => {
      resultActor ! (p, m)
    }
  }

  def startSearch(path: String): Unit = {
    val file = new File(path)

    if (file.isDirectory) {
      for (f <- file.listFiles()) {
        startSearch(f.getPath)
      }
    }
    else if (file.isFile) {
      val fileRegexActor = actorSystem.actorOf(FileRegexActor.props())
      fileRegexActor ! this
      fileRegexActor ! regex
      fileRegexActor ! file
    }
  }
}


object RegexActor {
  def props(actorSystem: ActorSystem, collectorActor: ActorRef): Props = Props(new RegexActor(actorSystem, collectorActor))
}

class FileRegexActor() extends Actor() {
  var regex: Regex = null

  override def receive = {
    case r: Regex => regex = r
    case f: File => {
      val bytes = new FileInputStream(f)
      var sb = new StringBuilder()

      while (bytes.available() > 0) {
        sb += bytes.read().asInstanceOf[Char]
      }
      val matchResult = regex.findAllIn(sb.toString())

      if (!matchResult.isEmpty) {
        sender ! (f.getPath, matchResult)
      }

    }
  }
}

object FileRegexActor {
  def props(): Props = Props[FileRegexActor]
}


class CollectorActor() extends Actor() {
  override def receive = {
    case (p: String, m: MatchIterator) => {
      println("Path: " + p)
      println("Match:" + m.mkString(" "))
    }
  }
}

object CollectorActor {
  def props(): Props = Props[CollectorActor]
}


//#main-class
object AkkaQuickstart extends App {


  def taskPrinter(num: Int) = {
    println("\n==================")
    println("Task" + num)
    println("==================")
  }


  taskPrinter(1)

  val system: ActorSystem = ActorSystem("lab5")


  val resultActor: ActorRef = system.actorOf(ResultActor.props())

  println("Creating array")
  var array = Seq.fill(1000000)(Random.nextInt)
  println("Array created")

  var sw = Stopwatch.start()
  var total = 0

  array.foreach(total += _)

  println("Single thread")
  println("Elapsed: " + sw.elapsed())
  println("Mean value of array:" + total / 1000000)

  var calc1 = system.actorOf(Calculator.props(resultActor))
  var calc2 = system.actorOf(Calculator.props(resultActor))
  var calc3 = system.actorOf(Calculator.props(resultActor))

  sw.reset()
  //println("Calc1")
  calc1 ! array.take(333333)
  //println("Calc2")
  calc2 ! array.slice(333333, 666666)
  //println("Calc3")
  calc3 ! array.slice(666666, 1000000)

  println("Three threads")
  println("Elapsed: " + sw.elapsed())


  Thread.sleep(1500)
  taskPrinter(2)
  println("Inverting image")

  var imgFile = new File("tree.jpg")

  var img = ImageIO.read(imgFile)

  val inverterActor1 = system.actorOf(InverterActor.props())
  val inverterActor2 = system.actorOf(InverterActor.props())
  val inverterActor3 = system.actorOf(InverterActor.props())

  inverterActor1 ! (500, 1500)
  inverterActor1 ! "imgInverted.jpg"
  inverterActor1 ! img

  inverterActor2 ! (1000, 2500)
  inverterActor2 ! "imgInverted.jpg"
  inverterActor2 ! img


  inverterActor3 ! (2000, 2900)
  inverterActor3 ! "imgInverted.jpg"
  inverterActor3 ! img

  taskPrinter(3)

  var collectorActor = system.actorOf(CollectorActor.props())
  var regexActor = system.actorOf(RegexActor.props(system, collectorActor))

  var r = new Regex("scala_actors")

  regexActor ! r
  regexActor ! "C:\\Actors"

}