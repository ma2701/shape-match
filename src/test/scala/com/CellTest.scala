package com

import java.awt.Point

import com.shape.{HollowCircle, HollowSquare}
import org.scalatest.FunSuite

class CellTest extends FunSuite {

    test("given two cells in same location then they are equal") {
        assert(new Cell(new Point) == new Cell(new Point))
    }

    test("given two cells in different locations then they are not equal") {
        assert(new Cell(new Point) != new Cell(new Point(10,0)))
    }

    test("given two cells in same locations then they are equal") {
        assert(new Cell(new Point(10,0)) == new Cell(new Point(10,0)))
    }

    test("given two cells one with embedded shape then they are not equal") {
        val cellOne = new Cell(new Point(10, 0))
        val cellTwo = new Cell(new Point(10, 0))

        assert(cellOne.withShape(new HollowSquare()) != cellTwo)
    }

    test("given two cells containing exactly the same shapes then they are equal") {
        val cellOne = new Cell(new Point(10, 0))
        val cellTwo = new Cell(new Point(10, 0))

        assert(cellOne.withShape(new HollowSquare()) == cellTwo.withShape(new HollowSquare()))
    }

    test("given two cells containing different shapes then they are not equal") {
        val cellOne = new Cell(new Point(10, 0))
        val cellTwo = new Cell(new Point(10, 0))

        assert(cellOne.withShape(new HollowSquare()) != cellTwo.withShape(new HollowCircle()))
    }

}
