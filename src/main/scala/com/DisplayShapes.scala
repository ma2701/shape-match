package com

class DisplayShapes {

    def getShapes(currentLevel: GameLevel): Map[String, Seq[Shape]] = {

        val shapesOnLeft = ShapeSelector.select(currentLevel)
        val shapesOnRight = shapesOnLeft

        Map("left" -> shapesOnLeft, "right" -> shapesOnRight)
    }

}
