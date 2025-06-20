// https://www.baeldung.com/scala/sorting


object OrderingPlayground extends App {

  case class User(name: String, age: Int)

  val users = List(
    User("Mike", 43),
    User("Mike", 16),
    User("Andrew", 16),
    User("Zenobia", 16),
    User("Kelly", 21)
  )
  //Using sorted
  //  implicit val userOrdering: Ordering[User] = Ordering.by(_.age)
  //  implicit val userOrdering: Ordering[User] = Ordering.by[User, Int](_.age).reverse

  //  println(users.sorted)

  // using soryBy
  println(users.sortBy(_.age))
  println(users.sortBy(_.age)(Ordering[Int].reverse))

  //Creating custom order: https://stackoverflow.com/questions/14695833/scala-idiom-for-ordering-by-multiple-criteria/14696410#14696410
  val ordering = Ordering.by { u: User => (u.age, u.name) }
  println(users.sorted(ordering))

  val ordering2 = Ordering.by[User, (Int, String)](u => (u.age, u.name))(Ordering[(Int, String)])
  println(users.toSeq.sortBy(u => u)(ordering2))
  //  println(users.sorted(ordering2))


//  object A {
//
//    def foo[T](
//                a: T,
//                f: T => Int
//              ): Int = f(a)
//
//
//    def foo2[T](a: T) =
//      new {
//      def apply(
//                 f: T => Int
//               ): Int = f(a)
//    }
//
//    foo(User("PRO", 12), _.age))
//
//    foo2(User("PRO", 12))(_.age)
//  }
}