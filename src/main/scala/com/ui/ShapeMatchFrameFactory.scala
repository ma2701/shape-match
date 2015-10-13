package com.ui

import com._

trait ShapeMatchFrameFactory {
    def construct: ShapeMatchFrame
}

object RealShapeMatchFrameFactory extends ShapeMatchFrameFactory {

    override def construct: ShapeMatchFrame = {
        val uiElements = UIElements.default

        val displayWindow = uiElements.displayWindow

        val gameTimer = new GameTimer(uiElements.topPanel.uiElements.countdownTimerPanel)

        val timerThread = new Thread(gameTimer)

        val levelOne = LevelOne.instance

        val gameLogic = GameLogic(levelOne, DisplayShapes.getShapesForLevel(levelOne, displayWindow), displayWindow)

        val frame = new ShapeMatchFrame(Game(uiElements, gameLogic, gameTimer),
                                        uiElements,
                                        timerThread)

        gameTimer.addTimerExpirySubscriber(frame)

        uiElements.matchButton.addActionListener(frame)
        uiElements.mismatchButton.addActionListener(frame)
        uiElements.addMainFrameAsActionListenerToLayeredPane(frame)

        return frame
    }
}

