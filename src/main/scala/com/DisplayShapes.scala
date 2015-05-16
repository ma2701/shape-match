package com

import com.util.random.{RandomBoolean, RandomNumberGenerator}

class DisplayShapes {

    def getShapes(currentLevel: GameLevel): Map[String, Seq[Shape]] = {

        val shapesOnLeft   = ShapeSelector.select(currentLevel)
        val shapesOnRight  = maybeAlterShapes(shapesOnLeft, RandomBoolean.nextRandomTrueWithOneOutOfNChance(3))

        Map("left" -> shapesOnLeft, "right" -> shapesOnRight)
    }

    def maybeAlterShapes(shapes: Seq[Shape] , shouldAlterShapes: Boolean):Seq[Shape] =  {

        if(shouldAlterShapes) {

            val index = RandomNumberGenerator.next(0 to (shapes.size - 1))
            val toBeReplaced = shapes(index)

            val replacement  = ShapeSelector.selectOneRandomShape.moveTo(toBeReplaced.topLeft)

            shapes.updated(index, replacement)

        } else {
            shapes
        }
    }
}

