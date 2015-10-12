package com

import com.ui.UIElements

case class TestGame (uiElements: UIElements,
                    var gameLogic: GameLogic) {

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
        println("user has selected to continue game")
        println("start a new game ( clear the boards...)")
        println("start a new game reset the timer ..etc")
    }

    def handleGameQuit:Unit = {
        println("user wants to quit the game ...")
        println("easy peasy...")
    }

    def handelTimerExpiry:Unit = {
        uiElements.layeredPane.uiElements.finalScorePanel.setFinalScore(gameLogic.score.points)
        uiElements.layeredPane.displayFinalScore

        gameLogic = gameLogic.markGameAsFinished

        updateUI
    }

}

