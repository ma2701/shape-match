package com

import java.awt.Dimension

import org.scalatest.FunSuite
import DisplayGrid._

class DisplayGridTest extends FunSuite {

    val testDimension= new Dimension(10, 10)

    test("can create instance of display grid") {
        new DisplayGrid(new DisplayWindow(new Dimension(10,10)))
    }

    test("given display grid then getGridCells returns the N * M celss") {

        val cells  = new DisplayGrid(new DisplayWindow(testDimension)).cells

        assert(GRID_ROW_CNT === cells.size )
    }

    test("given display grid then toString displays grid content") {
        val grid = new DisplayGrid(new DisplayWindow(testDimension))

        assert(GRID_ROW_CNT === grid.cells.size )

        val gridInStringForm = grid.toString

        assert( GRID_ROW_CNT * GRID_COL_CNT  === "width".r.findAllMatchIn(gridInStringForm).length)
    }

    test("given display of 10x10 then each cell is 1x1") {

        val grid = new DisplayGrid(new DisplayWindow(testDimension))

        assert(GRID_ROW_CNT === grid.cells.size )

        grid.cells.foreach(row => assert(GRID_COL_CNT === row.size ) )

        grid.cells.foreach(row => row.foreach(
            col => assert(col.dimension.width == 1 && col.dimension.height == 1 ))
        )
    }

}
