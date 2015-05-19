package com

sealed trait GameLevel {
    val shapeCount: Int

    def nextLevel: GameLevel

    def isLastLevel: Boolean = (nextLevel == LevelNull)

    // for now the points for each level is equal to the
    // shape count presented in that level.
    def points   = shapeCount

    override def toString:String = s"${getClass.getSimpleName.replaceFirst("\\$", "")}"
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

    override def nextLevel: GameLevel = LevelEight
}

object LevelEight extends GameLevel {
    override val shapeCount: Int = 8

    override def nextLevel: GameLevel = LevelNine
}

object LevelNine extends GameLevel {
    override val shapeCount: Int = 9

    override def nextLevel: GameLevel = LevelTen
}

object LevelTen extends GameLevel {
    override val shapeCount: Int = 10

    override def nextLevel: GameLevel = LevelEleven
}
object LevelEleven extends GameLevel {
    override val shapeCount: Int = 11

    override def nextLevel: GameLevel = LevelNull
}

object LevelNull extends GameLevel {
    override val shapeCount: Int = -1

    override def nextLevel: GameLevel = null
}
