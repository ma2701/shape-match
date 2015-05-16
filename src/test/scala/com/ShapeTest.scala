package com

import java.awt.Point

import org.scalatest.FunSuite

class ShapeTest extends FunSuite {

    test("given an abstract shape then we can create a concrete shape") {
        new Square(new Point)
    }

    test("given two squares in two different locations then they are not equal") {
        assert( new Square(new Point) != new Square(new Point(10,10)))
    }

    test("given two squares with same locations then they are equal") {
        new Square(new Point)

        assert(new Square == new Square())
    }

    test("given an ordered collection of different shapes then the collections are not equal") {
        val collection1 = Seq(new Square(new Point(10,20)))
        val collection2 = Seq(new Circle(new Point(10,20)))

        assert(collection1 != collection2)
    }

    test("given an ordered collection of squares with different locations then the collections are not equal") {
        val collection1 = Seq(new Square(new Point(10,20)), new Square(new Point(20,30)))
        val collection2 = Seq(new Square(new Point(40,20)), new Square(new Point(20,30)))

        assert(collection1 != collection2)
    }

    test("given an ordered collection of squares with exactly the same shapes then the collections are equal") {
        val collection1 = Seq(new Square(new Point(10,20)), new Square(new Point(20,30)))
        val collection2 = Seq(new Square(new Point(10,20)), new Square(new Point(20,30)))

        assert(collection1 == collection2)
    }

}
