package com

import com.util.random.RandomNumberGenerator

class DisplayShapes {
    def getShapes(currentLevel: GameLevel): Map[String, Seq[Shape]] = {

        val shapesOnLeft   = ShapeSelector.select(currentLevel)
        val shapesOnRight  = shapesOnLeft

        Map("left" -> shapesOnLeft, "right" -> shapesOnRight)
    }

    def copySelectedImage(shapes: Seq[Shape] , b: Boolean):Seq[Shape] =  {

        if(b) {

            val index = RandomNumberGenerator.next(0 to (shapes.size - 1))
            val toBeReplaced = shapes(index)

            val replacement  = ShapeSelector.selectOneRandomShape.moveTo(toBeReplaced.topLeft)

            shapes.updated(index, replacement)
        }
        else shapes
    }
}
