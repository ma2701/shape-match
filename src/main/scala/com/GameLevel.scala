package com

case class GameLevel(shapeCount: Int) {

    def nextLevel: GameLevel =
        if (hasReachedMaxLevel)
            this
        else GameLevel(shapeCount + 1)

    // for now the points for each level is equal to the
    // shape count presented in that level.
    def points = shapeCount

    private def hasReachedMaxLevel: Boolean =
        shapeCount == DisplayGrid.GRID_COL_CNT * DisplayGrid.GRID_COL_CNT

    override def toString: String = s"${shapeCount}"
}
