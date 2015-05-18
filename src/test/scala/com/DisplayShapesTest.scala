package com

import org.scalatest.FunSuite

class DisplayShapesTest extends FunSuite {

    test("given display shape and game level one then getShapes returns the shapes to be displayed") {
        DisplayShapes.getShapes(LevelOne)
    }

    test("given display shape object and level one then getShapes returns shapes to be displayed on the right as well as left screen") {
        val shapes = DisplayShapes.getShapes(LevelOne)

        assert(shapes.left != Nil)
        assert(shapes.right != Nil)
    }

    test("given display shape object and level one then getShapes returns one ") {
        val shapes = DisplayShapes.getShapes(LevelOne)

        assert(shapes.left.size == shapes.right.size)

        assert(shapes.left.size == LevelOne.shapeCount)
    }

    test("given display shape object when true then createCopy returns a copy of selected image with ONE image changed") {
        val shouldModifyOneImage = true

        val originalSelectedShapes = Seq(Square())

        val copiedShapes = DisplayShapes.maybeAlterShapes(originalSelectedShapes, shouldModifyOneImage)

        assert( copiedShapes.size === originalSelectedShapes.size )
    }

    test("given display shape object when true then replaced image has the same location as the shape it is replacing") {
        val shouldModifyOneImage = true

        val originalSelectedShapes = Seq(Square())

        val copiedShapes = DisplayShapes.maybeAlterShapes(originalSelectedShapes, shouldModifyOneImage)

        assert( copiedShapes(0).topLeft === originalSelectedShapes(0).topLeft)
    }

}
