package com

sealed trait GameLevel {
    val shapeCount: Int

    def nextLevel: GameLevel

    def isLastLevel: Boolean = (nextLevel == LevelNull)

}

object LevelOne extends GameLevel {
    override val shapeCount: Int = 1

    override def nextLevel: GameLevel = LevelTwo
}

object LevelTwo extends GameLevel {
    override val shapeCount: Int = 2

    override def nextLevel: GameLevel = LevelThree
}

object LevelThree extends GameLevel {
    override val shapeCount: Int = 3

    override def nextLevel: GameLevel = LevelFour
}

object LevelFour extends GameLevel {
    override val shapeCount: Int = 4

    override def nextLevel: GameLevel = LevelFive
}

object LevelFive extends GameLevel {
    override val shapeCount: Int = 5

    override def nextLevel: GameLevel = LevelSix
}

object LevelSix extends GameLevel {
    override val shapeCount: Int = 6

    override def nextLevel: GameLevel = LevelSeven
}

object LevelSeven extends GameLevel {
    override val shapeCount: Int = 7

    override def nextLevel: GameLevel = LevelNull
}

object LevelNull extends GameLevel {
    override val shapeCount: Int = -1

    override def nextLevel: GameLevel = null
}
