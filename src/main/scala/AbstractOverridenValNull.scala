//https://docs.scala-lang.org/tutorials/FAQ/initialization-order.html

abstract class A {
  val x1: String
  val x2: String = "mom"

  println("A: " + x1 + ", " + x2)
}
class B extends A {
  val x1: String = "hello"

  println("B: " + x1 + ", " + x2)
}
class C extends B {
//  override val x1 = "hola"
  override val x2: String = "dad"

  println("C: " + x1 + ", " + x2)
}

object JustTesting extends App {
  new C
}
