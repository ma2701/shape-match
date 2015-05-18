package com

import java.awt.Point

import com.shape.{HollowCircle, HollowSquare}
import org.scalatest.FunSuite

class ShapeTest extends FunSuite {

    test("given an abstract shape then we can create a concrete shape") {
        new HollowSquare(new Point)
    }

    test("given two squares in two different locations then they are not equal") {
        assert( new HollowSquare(new Point) != new HollowSquare(new Point(10,10)))
    }

    test("given two squares with same locations then they are equal") {
        new HollowSquare(new Point)

        assert(new HollowSquare == new HollowSquare())
    }

    test("given an ordered collection of different shapes then the collections are not equal") {
        val collection1 = Seq(new HollowSquare(new Point(10,20)))
        val collection2 = Seq(new HollowCircle(new Point(10,20)))

        assert(collection1 != collection2)
    }

    test("given an ordered collection of squares with different locations then the collections are not equal") {
        val collection1 = Seq(new HollowSquare(new Point(10,20)), new HollowSquare(new Point(20,30)))
        val collection2 = Seq(new HollowSquare(new Point(40,20)), new HollowSquare(new Point(20,30)))

        assert(collection1 != collection2)
    }

    test("given an ordered collection of squares with exactly the same shapes then the collections are equal") {
        val collection1 = Seq(new HollowSquare(new Point(10,20)), new HollowSquare(new Point(20,30)))
        val collection2 = Seq(new HollowSquare(new Point(10,20)), new HollowSquare(new Point(20,30)))

        assert(collection1 == collection2)
    }

}
