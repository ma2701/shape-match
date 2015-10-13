package com

import java.awt.{Dimension, Point}

import com.DisplayGrid._
import com.shape.{DisplayShapes, HollowSquare}
import org.scalatest.FunSuite

class DisplayGridTest extends FunSuite {

    val testDimension = new Dimension(10, 10)
    val testWindow    = new DisplayWindow(testDimension)

    val shapes        = List(new HollowSquare(new Point))
    val slots         = DisplayShapes.getSlotIndicesToPutShapesIn(shapes)

    test("can create instance of display grid") {
        new DisplayGrid(testWindow, shapes, slots)
    }

    test("given display grid then getGridCells returns the N * M celss") {

        val cells = new DisplayGrid(testWindow, shapes, slots).cells

        assert(GRID_ROW_CNT === cells.size)
    }

    test("given display of 10x10 then each cell is 1x1") {

        val grid = new DisplayGrid(testWindow, shapes, slots)

        assert(GRID_ROW_CNT === grid.cells.size)

        grid.cells.foreach(row => assert(GRID_COL_CNT === row.size))

        assertResult(new Point(0, 0)) {
            grid.cells(0)(0).topLeft
        }
        assertResult(new Point(5, 5)) {
            grid.cells(5)(5).topLeft
        }
    }

    test("given display of then translate row/col to index into an array") {

        val grid = new DisplayGrid(testWindow, shapes, slots)

        assertResult(0) {
            grid.toIndex((0,0))
        }

        assertResult(1) {
            grid.toIndex((0, 1))
        }

        assertResult(35) {
            grid.toIndex((5, 5))
        }
    }

    test("given display and list of shapes then all shapes are randomly distributed in the grid cells") {

        val shapes = Seq(HollowSquare(), HollowSquare(), HollowSquare(), HollowSquare())

        val slots = DisplayShapes.getSlotIndicesToPutShapesIn(shapes)

        val grid = new DisplayGrid(testWindow, shapes, slots)

        assertResult(shapes.size) {
            grid.cells.foldLeft(0) { (acc, arr) =>
                acc + arr.count(_.shape.isDefined)
            }
        }
    }

    test("given display grid then can get the count of shapes in the grid") {

        val shapes = Seq(HollowSquare(), HollowSquare(), HollowSquare(), HollowSquare())

        val slots = DisplayShapes.getSlotIndicesToPutShapesIn(shapes)

        assert(4 === new DisplayGrid(testWindow, shapes, slots).shapesInGrid)
    }

    test("given display grid when no alteration then maybeAlterShapes returns the same grid") {
        val shapes = Seq(HollowSquare())
        val slots  = DisplayShapes.getSlotIndicesToPutShapesIn(shapes)

        val grid = new DisplayGrid(testWindow, shapes, slots)

        assert(grid.isEqual(grid.maybeAlterShapes(false)))
    }

    test("given two grid of with ex shapes then they are both 'equal' ") {
        val shapes = Seq(HollowSquare(), HollowSquare(), HollowSquare(), HollowSquare())

        val slots = DisplayShapes.getSlotIndicesToPutShapesIn(shapes)

        val grid  = new DisplayGrid(testWindow,  shapes, slots)
        val grid2 = new DisplayGrid(testWindow,  shapes, slots)

        assert(grid.isEqual(grid2))
    }

}
