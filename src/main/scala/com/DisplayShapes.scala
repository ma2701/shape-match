package com

class DisplayShapes {

    def getShapes(currentLevel: GameLevel): Map[String, Seq[Shape]] = {

        val shapesOnLeft = ShapeSelector.select(currentLevel)
        val shapesOnRigt = Nil

        Map("left" -> shapesOnLeft, "right" -> shapesOnRigt)
    }

}
