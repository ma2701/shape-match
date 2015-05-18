package com

import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class GameLogicTest extends FunSuite with MockitoSugar {

    test("can create instance") {
        val game = new GameLogic
    }

    test("given a game then start it") {
        val game = new GameLogic().start
    }

    test("given a game when user selects match and left and right match then isUserInputCorrect returns GameLogic with level increased") {
        val shapes   =  DisplayShapesPair(Seq(new Square), Seq(new Square))

        val userInput = Match

        val gl = new GameLogic(LevelOne, shapes).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelTwo)
    }

    test("given a game when user selects mismatch and left and right match then game remains in the current level") {
        val userInput = Mismatch

        val shapes   =  DisplayShapesPair(Seq(new Square), Seq(new Square))

        val gl = new GameLogic(LevelOne, shapes).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelOne)
    }

    test("given a game when user selects mismatch and left and right shapes do not match then move to new level") {
        val userInput = Mismatch

        val shapes   =  DisplayShapesPair(Seq(new Circle), Seq(new Square))

        val gl = new GameLogic(LevelOne, shapes).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelTwo)
    }

    test("given a game when user selects mismatch and either left or right shape is missing then move to next level") {
        val userInput = Mismatch

        val rightShape= Seq(new Square)

        val shapes   =  DisplayShapesPair(Nil, rightShape)

        val gl = new GameLogic(LevelOne, shapes).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelTwo)
    }

    test("given a game when user selects correctly then the next level has shape count corresponding to the level") {
        val shapes   =  DisplayShapesPair(Seq(new Square), Seq(new Square))

        val userInput = Match

        val gl = new GameLogic(LevelOne, shapes).isUserInputCorrect(userInput)

        assert (gl.shapesPair.left.size == LevelTwo.shapeCount)
        assert (gl.shapesPair.right.size == LevelTwo.shapeCount)
    }

    test("given a game when game is not over then isGameOver returns false") {
        assertResult(false){
            new GameLogic().isGameOver
        }
    }

    test("given a game when no next level exist then isGameOver returns true") {
        assert(new GameLogic(LevelSeven).isGameOver)
    }
}
