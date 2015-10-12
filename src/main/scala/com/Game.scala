package com

import java.awt.EventQueue

import com.ui.UIElements

case class Game (uiElements: UIElements,
                 var gameLogic: GameLogic,
                 gameTimer: GameTimer ) {

    def updateUI:Unit = {
        uiElements.drawShapes(gameLogic.shapesPair.leftGrid,
            gameLogic.shapesPair.rightGrid)
    }

    def processUserInput(userInput: UserInput): Unit = {
        gameLogic = gameLogic.evaluateUserInput(userInput).copy(displayWindow = uiElements.displayWindow)

        uiElements.topPanel.setCurrentStats(gameLogic.currentLevel, gameLogic.score.points).updateGameLevelText

        updateUI
    }

    def handleGameContinue:Unit = {
        gameLogic = gameLogic.reset
        uiElements.layeredPane.displayShapePanels
        gameTimer.resetTimer
        updateUI
    }

    def handleGameQuit:Unit = EventQueue.invokeLater( new ApplicationDeath)

    def handelTimerExpiry:Unit = {
        uiElements.layeredPane.uiElements.finalScorePanel.setFinalScore(gameLogic.score.points)
        uiElements.layeredPane.displayFinalScore

        gameLogic = gameLogic.markGameAsFinished

        updateUI
    }

}

