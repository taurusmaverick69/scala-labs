def appendLines(target: {def append(str: String): Any}, lines: Iterable[String]) {
  for (l <- lines) {
    target.append(l)
    target.append("\n")
  }
}

val iterable = Iterable("1", "2")
appendLines(new {
  def append(str: String): Any = {
    "te"
  }
}, Array("test"))


//def foo(x: {def get: Int}) = 123 + x.get
//foo(new {
//  def get = 10
//})