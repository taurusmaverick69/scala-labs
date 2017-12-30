"Hello world".getClass.getName
"hello".foreach(println)

"hello".getBytes().foreach(println)

"hello world".filter(_ != 'l')


"scala".drop(2).take(2).capitalize


//Testing String Equality
val s1 = "HelLo"
val s2 = "Hello"
val s3 = "H" + "ello"

s1 == s2
s2 == s3
s1 == s3

val s4: String = null
s3 == s4

s1.toUpperCase == s2.toUpperCase

s1.equalsIgnoreCase(s2)


//1.2. Creating Multiline Strings
val foo =
  """This is
a multiline
String"""
val speech1 =
  """Four score and
    |seven years ago""".stripMargin
val speech2 =
  """Four score and
#seven years ago""".stripMargin('#')



//1.3. Splitting Strings
"hello world".split(" ").foreach(println)
val s = "eggs, milk, butter, Coco Puffs"
s.split(",").map(_.trim)
"hello world".split(" ")
"hello world".split(' ')





//1.4. Substituting Variables into Strings
val name = "Fred"
val age = 33
val weight = 200.00

println(s"$name is $age + years old, and weighs $weight pounds.")
println(s"Age next year: ${age + 1}")
println(s"You are 33 years old: ${age == 33}")


case class Student(name: String, score: Int)

val hannah = Student("Hannah", 95)
println(s"${hannah.name} has a score of ${hannah.score}")

println(f"$name is $age years old, and weighs $weight%.2f pounds.")
println(f"$name is $age years old, and weighs $weight%.0f pounds.")

val out = f"$name, you weigh $weight%.0f pounds."

s"foo\nbar"
raw"foo\nbar"

val testS = "%s is %d years old".format(name, age)




//1.5. Processing a String One Character at a Time
"hello, world".filter(_ != 'l').map(_.toUpper)

// first example
"HELLO".map(c => (c.toByte + 32).toChar)
// second example
"HELLO".map { c =>
  (c.toByte + 32).toChar
}

// write your own method that operates on a character
def toLower(c: Char): Char = (c.toByte + 32).toChar
"HELLO".map(toLower)




//1.6. Finding Patterns in Strings
val numPattern = "[0-9]+".r
val address = "123 Main Street Suite 101"
val match1 = numPattern.findFirstIn(address)
val matches = numPattern.findAllIn(address)
matches.toArray
match1.getOrElse("NO")
match1.foreach { e =>
  println(s"$e")
}

//1.7. Replacing Patterns in Strings
"123 Main Street".replaceAll("[0-9]", "x")