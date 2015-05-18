package com

import com.shape.Shape
import com.util.random.{RandomBoolean, RandomNumberGenerator}
import DisplayGrid._

object DisplayShapes {

    def getShapes(currentLevel: GameLevel, displayWindow:DisplayWindow) : DisplayShapesPair  = {
        val shapes: Seq[Shape] = ShapeSelector.select(currentLevel)

        val slots = getSlotIndicesToPutShapesIn(shapes)

        val shapesOnLeft   = new DisplayGrid(displayWindow, shapes, slots)
        val shapesOnRight  = shapesOnLeft.maybeAlterShapes()

        DisplayShapesPair(shapesOnLeft, shapesOnRight)
    }

    def getSlotIndicesToPutShapesIn(shapes: Seq[Shape]): Set[Int] = {
        RandomNumberGenerator.nextNDistinct(shapes.size, 0 to ((GRID_COL_CNT * GRID_ROW_CNT) - 1))
    }
}
