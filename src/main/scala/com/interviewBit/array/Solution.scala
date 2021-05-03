package com.interviewBit.array

/**
 * {{ https://www.interviewbit.com/problems/min-steps-in-infinite-grid/ }}
 */
class Solution {
  def coverPoints(A: Array[Int], B: Array[Int]): Int = {
    val coordinates: Vector[(Int, Int)] = A.zip(B).toVector

    def getTotalMoves(a: (Int, Int), coordinates: Vector[(Int, Int)], acc: Int): Int = {
      (a, coordinates) match {
        case (_, IndexedSeq()) => acc
        case ((a: Int, b: Int), head +: tail) => {
          val moves = move((a, b), (head._1, head._2))
          getTotalMoves(head, tail, acc + moves)
        }
      }
    }

    getTotalMoves(coordinates.head, coordinates.tail, 0)
  }

  def move(a: (Int, Int), b: (Int, Int)): Int = {
    Math.max(Math.abs(b._1 - a._1), Math.abs(b._2 - a._2))
  }
}

object TestFunct extends App {
  val sol = new Solution()
  println(sol.coverPoints(Array(1, 2, 3), Array(1, 2, 3)))
}