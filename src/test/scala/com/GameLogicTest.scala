package com

import java.awt.Dimension

import com.shape.{HollowCircle, HollowSquare}
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class GameLogicTest extends FunSuite with MockitoSugar {

    val gameLevelOne       = LevelOne
    val displayWindow      = new DisplayWindow(new Dimension(10,10))

    val shapes             = Seq(new HollowSquare, new HollowSquare)
    val nonMatchingShapes  = Seq(new HollowSquare, new HollowCircle())

    val slots         = DisplayShapes.getSlotIndicesToPutShapesIn(shapes)

    val matchingDisplayShapesPair = new DisplayShapesPair(leftGrid = new DisplayGrid(displayWindow, shapes, slots),
                                                  rightGrid = new DisplayGrid(displayWindow, shapes, slots))

    val nonMatchingDisplayShapesPair = new DisplayShapesPair(leftGrid = new DisplayGrid(displayWindow, shapes, slots),
                                                  rightGrid = new DisplayGrid(displayWindow, nonMatchingShapes, slots))

    test("given a game then start it") {
        val game = new GameLogic(gameLevelOne,matchingDisplayShapesPair, displayWindow).start
    }

    test("given a game when user selects match and left and right match then isUserInputCorrect returns GameLogic with level increased") {
        val userInput = Match

        val gl = new GameLogic(gameLevelOne, matchingDisplayShapesPair, displayWindow).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelTwo)
    }

    test("given a game when user selects mismatch and left and right match then game remains in the current level") {
        val userInput = Mismatch

        val gl = new GameLogic(gameLevelOne, matchingDisplayShapesPair, displayWindow).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelOne)
    }

    test("given a game when user selects mismatch and left and right shapes do not match then move to new level") {
        val userInput = Mismatch

        val gl = new GameLogic(gameLevelOne, nonMatchingDisplayShapesPair, displayWindow).isUserInputCorrect(userInput)

        assert (gl.currentLevel == LevelTwo)
    }

    test("given a game when user selects correctly then the next level has shape count corresponding to the level") {
        val userInput = Match

        val gl = new GameLogic(gameLevelOne, matchingDisplayShapesPair, displayWindow).isUserInputCorrect(userInput)

        assert (gl.shapesPair.leftGrid.shapesInGrid  === LevelTwo.shapeCount)
        assert (gl.shapesPair.rightGrid.shapesInGrid === LevelTwo.shapeCount)
    }

    test("given a game when game is not over then isGameOver returns false") {
        assertResult(false){
            new GameLogic(gameLevelOne, matchingDisplayShapesPair, displayWindow).isGameOver
        }
    }

    test("given a game when no next level exist then isGameOver returns true") {
        assert(new GameLogic(LevelSeven, matchingDisplayShapesPair, displayWindow).isGameOver)
    }
}
