package com

case class GameLevel(shapeCount:Int ) {

    def nextLevel: GameLevel = if(shapeCount == 36 ) this else GameLevel(shapeCount + 1 )

    // for now the points for each level is equal to the
    // shape count presented in that level.
    def points   = shapeCount

    override def toString:String = s"${shapeCount}"
}
