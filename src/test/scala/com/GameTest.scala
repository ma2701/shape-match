package com

import com.ui.ShapeMatchFrame
import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar

class GameTest extends FunSuite with MockitoSugar {

    test("create instance") {
        val game = new Game(createAGameFrame)
    }

    test("given a Game instance then isGameOver returns true when game is over") {
        assert(new Game(createAGameFrame).isGameOver)
    }


    private def createAGameFrame:ShapeMatchFrame = {
        val mockShapeMatchFrame = mock[ShapeMatchFrame]

        doNothing().when(mockShapeMatchFrame).setVisible(true)

        return mockShapeMatchFrame
    }
    
}
