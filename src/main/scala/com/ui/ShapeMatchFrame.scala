package com.ui

import java.awt.{EventQueue, Color}
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JFrame

import com._
import org.jdesktop.layout.GroupLayout
object ShapeMatchFrame{
    val mainUIColor = new Color(0,0,0)
}

class ShapeMatchFrame extends JFrame with Runnable with ActionListener with TimerExpirySubscriber {

    private[this] val uiElements            = UIElements.default(this)
    private[this] val gameTimer             = new GameTimer(uiElements.topPanel.uiElements.countdownTimerPanel)

    private[this] var gameThread:  Thread   = _

    private[this] var timerThread: Thread   = _

    private[this] var gameLogic : GameLogic = _

    private[this] val levelOne              = GameLevel(1)

    gameTimer.addTimerExpirySubscriber(this)

    initComponents

    override def addNotify: Unit = {
        super.addNotify()

        gameThread = new Thread(this)
        gameThread.start()

        timerThread = new Thread(gameTimer)
        timerThread.start()
    }

    override def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = {

        val displayWindow =uiElements.displayWindow

        if(gameLogic == null)
            gameLogic = GameLogic(levelOne, DisplayShapes.getShapes(levelOne,displayWindow),displayWindow )

        uiElements.layeredPane.uiElements.rightShapePanel.drawShapes(gameLogic.shapesPair.rightGrid)

        uiElements.layeredPane.uiElements.leftShapePanel.drawShapes(gameLogic.shapesPair.leftGrid)

        if(gameLogic.isGameOver)
            EventQueue.invokeLater( new ApplicationDeath())

    }

    override def actionPerformed(e: ActionEvent): Unit = {

        val userInput = UserInput.fromString(e.getActionCommand)

        gameLogic     = gameLogic.evaluateUserInput(userInput).copy(displayWindow = uiElements.displayWindow)

        uiElements.topPanel.setCurrentStats(gameLogic.currentLevel, gameLogic.score.points).updateGameLevelText

        mainGameLoop
    }

    private def initComponents: Unit = {
        setResizable(false)

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        val layout = new GroupLayout(getContentPane())

        getContentPane().setLayout(layout)

        GameLayoutUtility.setMainFrameLayoutAttributes(layout, uiElements)

        pack()
    }

    override def timerHasExpired: Unit = {
        uiElements.layeredPane.uiElements.finalScorePanel.setFinalScore(gameLogic.score.points)
        uiElements.layeredPane.displayFinalScore

        gameLogic = gameLogic.gameOver
    }
}
