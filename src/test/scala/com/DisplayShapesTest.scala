package com

import org.scalatest.FunSuite

class DisplayShapesTest extends FunSuite {

    test("given display shape and game level one then getShapes returns the shapes to be displayed") {
        new DisplayShapes().getShapes(LevelOne)
    }

    test("given display shape object and level one then getShapes returns shapes to be displayed on the right as well as left screen") {
        val shapes = new DisplayShapes().getShapes(LevelOne)

        assert(shapes.get("left").isDefined)
        assert(shapes.get("right").isDefined)
    }

    test("given display shape object and level one then getShapes returns one ") {
        val shapes = new DisplayShapes().getShapes(LevelOne)

        assert(shapes.get("left").isDefined)
        assert(shapes.get("right").isDefined)

        assert(shapes.get("left").get.size == shapes.get("right").get.size)

        assert(shapes.get("left").get.size == LevelOne.shapeCount)
    }


}
