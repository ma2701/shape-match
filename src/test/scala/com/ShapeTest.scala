package com

import java.awt.Point

import org.scalatest.FunSuite

class ShapeTest extends FunSuite {

    test("given an abstract shape then we can create a concrete shape") {
        new Square(new Point)
    }


}
