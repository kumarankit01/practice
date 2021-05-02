package com.leetcode

object Sudoku extends App {
  def solveSudoku(board: Array[Array[Char]]): Unit = {
    val mapRow = Map[Int, List[Char]]()
    val mapcol = Map()
    val mapbox = Map()

    board.map {
      row =>
        row.map {
          e => mapRow + (board.indexOf(row) -> (e :: mapRow.getOrElse(board.indexOf(row), List())))
        }
    }
    println(mapRow)

  }

  solveSudoku(Array(Array(12)))
}
