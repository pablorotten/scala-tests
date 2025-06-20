object PatternMatching extends App {

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
      // 3 ways to do it
    case p: Person => s"Hi, my name is ${p.name} and I am ${p.age} years old"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case p @ Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }

  println(greeting)

  val someBob = Some(Person("Bob", 20))

  val someGreeting = someBob match {
    // 3 ways to do it
    case Some(p: Person) => s"case Some(p: Person) => Hi, my name is ${p.name} and I am ${p.age} years old"
    case Some(Person(n, a)) => s"case Some(Person(n, a)) => Hi, my name is $n and I am $a years old"
    case p @ Some(Person(n, a)) => s"case p @ Some(Person(n, a)) => Hi, my name is $n and I am $a years old"
    case _ => "case _ => I don't know who I am"
  }

  println(someGreeting)
}
