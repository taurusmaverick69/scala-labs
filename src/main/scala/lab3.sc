def middle(list: Seq[String]): String = {
  val randomNum = util.Random.nextInt(list.length)
  list(randomNum)
}