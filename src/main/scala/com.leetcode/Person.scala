package com.leetcode

object Person extends App {

  case class User(name: String, age: Int)

  trait Equal[T] {
    def apply(a: T, b: T): Boolean
  }

  implicit object NameEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name

    def x(a: User, b: User): Boolean = true

    def y(a: User, b: User): Boolean = true
  }

  object Equal {
    def apply[T](a: T, b: T)(implicit equal: Equal[T]): Boolean = equal(a, b)

    def equalizer[T](implicit equal: Equal[T]): Equal[T] = equal
  }

  val studs = List(User("A", 1), User("B", 1))
  implicit val sortStuds: Ordering[User] = Ordering.fromLessThan((a, b) => a.name.compareTo(b.name) > 0)

  //println(NameEquality(User("A", 1), User("B", 1)))
  println(Equal(User("A", 1), User("B", 1)))

  implicit class RichInt(val v: Int) extends AnyVal {
    def isEven = v % 2 == 0

    def times(f: Int => Int) = f(v)

    def *(l: List[Int]) = {
      def aux(n: Int): List[Int] = {
        if (n <= 0) l
        else aux(n-1) ++ l
      }
      aux(v)
    }
  }

  implicit class RichString(val a: String) extends AnyVal {
    def asInt = a.toInt
  }


  println("5".asInt)
  println(5.*(List(1, 2)))
}



