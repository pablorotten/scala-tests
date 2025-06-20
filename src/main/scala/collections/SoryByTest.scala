package collections

object SoryByTest extends App{

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val john = Person("John", 24)
  val michael = Person("Michael", 19)

  val persons = Seq(bob, john, michael)

  println(persons)
  println(persons.sortBy(_.age))


  println(persons.sortBy{ p =>
    p match {
      case p: Person => p.age
      case _  => -1
    }
  })


}
