package com

import org.scalatest.FunSuite

import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.mockito.Matchers._

class GameLogicTest extends FunSuite with MockitoSugar {

    test("can create instance") {
        val game = new GameLogic()
    }

    test("given a game then start it") {
        val game = new GameLogic().start
    }

    test("given a game when no shapes to display then getDisplayShapes returns an empty map of shapes") {
        val gameLvl = LevelOne

        val mockDisplayShapes = mock[DisplayShapes]

        when(mockDisplayShapes.getShapes(gameLvl)).thenReturn(Map[String,Seq[Shape]]())

        assert  ( 0 === new GameLogic(mockDisplayShapes).getDisplayShapes(gameLvl).size )

    }

    test("given a game when game level 1 display then getDisplayShapes returns one left and right shape") {
        val gameLvl = LevelOne

        val mockDisplayShapes = mock[DisplayShapes]

        val rightShape= Seq(new Square)
        val leftShape = Seq(new Circle)

        when(mockDisplayShapes.getShapes(gameLvl)).thenReturn(Map[String,Seq[Shape]]("right" -> rightShape, "left" -> leftShape))

        val shapes = new GameLogic(mockDisplayShapes).getDisplayShapes(gameLvl)

        assert  ( 2 === shapes.size )

        assertResult(rightShape) {
            shapes.get("right").get
        }

        assertResult(leftShape) {
            shapes.get("left").get
        }
    }

    test("given a game when user selects match and left and right match then isUserInputCorrect returns true") {
        val rightShape= "right" -> Seq(new Square)
        val leftShape = "left"  -> Seq(new Square)

        val shapes   =  Map.empty[String, Seq[Shape]] + (rightShape, leftShape)

        val userInput = Match

        assert (new GameLogic().isUserInputCorrect(userInput, shapes ))

    }

    test("given a game when user selects nomatch and left and right match then isUserInputCorrect returns false") {
        val userInput = NoMatch

        val rightShape= "right" -> Seq(new Square)
        val leftShape = "left"  -> Seq(new Square)

        val shapes   =  Map.empty[String, Seq[Shape]] + (rightShape, leftShape)

        assertResult(false){
            new GameLogic().isUserInputCorrect(userInput, shapes )
        }
    }

    test("given a game when user selects nomatch and left and right shapes do not match then isUserInputCorrect returns true") {
        val userInput = NoMatch

        val rightShape= "right" -> Seq(new Square)
        val leftShape = "left"  -> Seq(new Circle)

        val shapes   =  Map.empty[String, Seq[Shape]] + (rightShape, leftShape)

        assertResult(true){
            new GameLogic().isUserInputCorrect(userInput, shapes )
        }
    }

    test("given a game when user selects nomatch and either left or right shape is missing then isUserInputCorrect returns true") {
        val userInput = NoMatch

        val rightShape= "right" -> Seq(new Square)

        val shapes   =  Map.empty[String, Seq[Shape]] + (rightShape)

        assertResult(true){
            new GameLogic().isUserInputCorrect(userInput, shapes )
        }
    }


}
