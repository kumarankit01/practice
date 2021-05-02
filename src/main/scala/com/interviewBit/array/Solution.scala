package com.interviewBit.array

/**
 * {{ https://www.interviewbit.com/problems/min-steps-in-infinite-grid/ }}
 */
class Solution {
  def coverPoints(A: Array[Int], B: Array[Int]): Int = {
    val coordinates: Seq[(Int, Int)] = A.zip(B)
    var index = 0
    var totalMove = 0
    while (index < coordinates.length - 1) {
      val first = coordinates(index)
      val second = coordinates(index + 1)
      index += 1
      totalMove += move(first, second, 0)

    }
    totalMove
  }

  def move(a: (Int, Int), b: (Int, Int), acc: Int): Int = {
    if (a._1 != b._1 || a._2 != b._2) {
      val newAx: Int = if (a._1 < b._1) a._1 + 1
      else if (a._1 > b._1) a._1 - 1
      else a._1

      val newAy = if (a._2 < b._2) a._2 + 1
      else if (a._2 > b._2) a._2 - 1
      else a._2
      move((newAx, newAy), (b._1, b._2), acc + 1)
    } else {
      acc
    }
  }
}
