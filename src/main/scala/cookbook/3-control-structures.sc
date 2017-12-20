val a = Array("Apple", "Orange", "Banana")

for (i <- a.indices) {
  println(s"$i is ${a(i)}")
}


for ((e, count) <- a.zipWithIndex) {
  println(s"$count is $e")
}

for (i <- 1 to 10 if i < 4) println(i)


val names = Map("fname" -> "Robert",
  "lname" -> "Goren")
for ((k, v) <- names) println(s"key: $k, value: $v")


//3.2. Using for Loops with Multiple Counters
for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")


val array = Array.ofDim[Int](2, 2)
array(0)(0) = 0
array(0)(1) = 1
array(1)(0) = 2
array(1)(1) = 3

for {
  i <- 0 to 1
  j <- 0 to 1
} println(s"($i)($j) = ${array(i)(j)}")



//3.3. Using a for Loop with Embedded if Statements
//(Guards)


for (i <- 1 to 10 if i % 2 == 0) println(i)









