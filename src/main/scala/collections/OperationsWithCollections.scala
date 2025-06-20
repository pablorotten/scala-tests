package collections

object ConcatenateListOfStrings extends App {
  val list = Seq("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")

  val result = list.fold(""){ case (x, y) => s"$x$y"}
  println(result)
}