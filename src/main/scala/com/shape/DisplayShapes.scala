package com.shape

import com.DisplayGrid._
import com.util.random.RandomNumberGenerator
import com.{DisplayGrid, DisplayWindow, GameLevel}

object DisplayShapes {

    def getShapesForLevel(currentLevel: GameLevel, displayWindow: DisplayWindow): DisplayShapesPair = {
        val shapes = ShapeSelector.select(currentLevel)

        val slots = getSlotIndicesToPutShapesIn(shapes)

        val shapesOnLeft = new DisplayGrid(displayWindow, shapes, slots)
        val shapesOnRight = shapesOnLeft.maybeAlterShapes()

        DisplayShapesPair(shapesOnLeft, shapesOnRight)
    }

    def getSlotIndicesToPutShapesIn(shapes: Seq[Shape]): Set[Int] = {
        RandomNumberGenerator.nextNDistinctWithinRange(shapes.size, 0 to ((GRID_COL_CNT * GRID_ROW_CNT) - 1))
    }
}
