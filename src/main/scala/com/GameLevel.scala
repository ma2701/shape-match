package com

sealed trait GameLevel {
    val shapeCount:Int
}
object LevelOne extends GameLevel {
    override val shapeCount: Int = 1
}
object LevelTwo extends GameLevel {
    override val shapeCount: Int = 2
}
object LevelThree extends GameLevel {
    override val shapeCount: Int = 3
}
object LevelFour extends GameLevel {
    override val shapeCount: Int = 4
}
object LevelFive extends GameLevel {
    override val shapeCount: Int = 5
}
object LevelSix extends GameLevel {
    override val shapeCount: Int = 6
}
object LevelSeven extends GameLevel {
    override val shapeCount: Int = 7
}
