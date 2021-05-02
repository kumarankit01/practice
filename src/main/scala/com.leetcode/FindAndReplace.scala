package com.leetcode

object FindAndReplace extends App {

  /*
    H => h & `l & `i | `h & l & i

    L => h` & l` & i | h` & l & `i
    */
  /*  val num = List(10, 10, 132, 30, 30, 10, 30).foldLeft((0, 0)) {
      (a, b) => {
        val h = a._1 & ~a._2 & ~b | ~a._1 & a._2 & b
        val l = ~a._1 & ~a._2 & b | ~a._1 & a._2 & ~b
        println(h, l)
        (h, l)
      }
    }._2

    println(num)*/
  val a = Map[Int, Int]()
  val x = List(1, 2, 3).foldLeft(a)((a, e) => {
    a + (e -> e)
  })
  println(x)
}

case class Pos(r: Int, col: Int)
