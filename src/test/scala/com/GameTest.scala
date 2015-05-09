package com

import org.scalatest.FunSuite

class GameTest extends FunSuite{

    test("can create instance") {
        val game = new Game()
    }

    test("given a game then start it") {
        val game = new Game().start
    }

    test("given a game then can get current shapes to be displayed") {
        val game:DisplayShapes = new Game().getDisplayShapes
    }

}
