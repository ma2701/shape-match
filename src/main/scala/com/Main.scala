package com

import com.ui.RealShapeMatchFrameFactory

object Main extends App {

    override def main(args: Array[String]): Unit = {

        val game  = new Game(RealShapeMatchFrameFactory.construct)

        game.start
    }
}
