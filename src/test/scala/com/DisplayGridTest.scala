package com

import java.awt.{Point, Dimension}

import org.scalatest.FunSuite
import DisplayGrid._

class DisplayGridTest extends FunSuite {

    val testDimension= new Dimension(10, 10)
    val shapes       = List(new Square(new Point))

    test("can create instance of display grid") {
        new DisplayGrid(new DisplayWindow(testDimension), shapes)
    }

    test("given display grid then getGridCells returns the N * M celss") {

        val cells  = new DisplayGrid(new DisplayWindow(testDimension), shapes).cells

        assert(GRID_ROW_CNT === cells.size )
    }

    test("given display grid then toString displays grid content") {
        val grid = new DisplayGrid(new DisplayWindow(testDimension), shapes)

        assert(GRID_ROW_CNT === grid.cells.size )

        val gridInStringForm = grid.toString

        assert( GRID_ROW_CNT * GRID_COL_CNT  === "width".r.findAllMatchIn(gridInStringForm).length)
    }

    test("given display of 10x10 then each cell is 1x1") {

        val grid = new DisplayGrid(new DisplayWindow(testDimension), shapes)

        assert(GRID_ROW_CNT === grid.cells.size )

        grid.cells.foreach(row => assert(GRID_COL_CNT === row.size ) )

        grid.cells.foreach(row => row.foreach(
            col => assert(col.dimension.width == 1 && col.dimension.height == 1 ))
        )
    }

    test("given display of then translate index to row/col will return given index to a col/row tuple") {

        val grid = new DisplayGrid(new DisplayWindow(testDimension), shapes)

        assertResult((0,0)) {
            grid.toRowCol(0)
        }

        assertResult((0,1)) {
            grid.toRowCol(1)
        }

        assertResult((5,5)) {
            grid.toRowCol(35)
        }
    }

    test("given display of when invalid index given then exception is thrown") {

        val grid = new DisplayGrid(new DisplayWindow(testDimension), shapes)

        intercept[RuntimeException] {
            grid.toRowCol(( DisplayGrid.GRID_COL_CNT * DisplayGrid.GRID_ROW_CNT) )
        }
    }

    test("given display and list of shapes then all shapes are randomly distributed in the grid cells") {

        val shapes = Seq(Square(), Square(), Square(), Square())

        val grid = new DisplayGrid(new DisplayWindow(testDimension), shapes)

        assertResult(shapes.size) {
            grid.cells.foldLeft(0) { (acc, arr) =>
                 acc + arr.count( _.getShape.isDefined)
            }
        }
    }

}
