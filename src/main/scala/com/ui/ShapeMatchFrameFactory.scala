package com.ui

import com.{DisplayShapes, GameLogic, GameLevel, GameTimer}

trait ShapeMatchFrameFactory {
    def construct: ShapeMatchFrame
}

object RealShapeMatchFrameFactory extends ShapeMatchFrameFactory {

    override def construct: ShapeMatchFrame = {
        val uiElements = UIElements.default

        val displayWindow = uiElements.displayWindow

        val gameTimer = new GameTimer(uiElements.topPanel.uiElements.countdownTimerPanel)

        val timerThread = new Thread(gameTimer)

        val levelOne = GameLevel(1)

        val gameLogic = GameLogic(levelOne, DisplayShapes.getShapes(levelOne, displayWindow), displayWindow)

        val frame = new ShapeMatchFrame(uiElements, timerThread, gameTimer, gameLogic)

        uiElements.matchButton.addActionListener(frame)
        uiElements.mismatchButton.addActionListener(frame)

        return frame
    }
}

