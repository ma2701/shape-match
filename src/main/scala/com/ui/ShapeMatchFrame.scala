package com.ui

import java.awt.Dimension
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JFrame

import com._
import org.jdesktop.layout.GroupLayout

class ShapeMatchFrame extends JFrame with Runnable with ActionListener {

    private[this] val uiElements            = UIElements.default(this)
    private[this] var gameThread: Thread    = _
    private[this] var gameLogic : GameLogic = _

    initComponents

    override def addNotify: Unit = {
        super.addNotify()

        gameThread = new Thread(this)
        gameThread.start()
    }

    override def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = {
        val displayWindowDimension= new Dimension(uiElements.leftPanel.getWidth, uiElements.leftPanel.getHeight)

        val displayWindow = new DisplayWindow(displayWindowDimension)

        gameLogic = new GameLogic(LevelOne, DisplayShapes.getShapes(LevelOne,displayWindow), displayWindow)

        uiElements.rightPanel.drawShapes(gameLogic.shapesPair.rightGrid)

        uiElements.leftPanel.drawShapes(gameLogic.shapesPair.leftGrid)

        if (gameLogic.isGameOver)
            System.exit(0) // temp
    }

    override def actionPerformed(e: ActionEvent): Unit = {
        val userInput = UserInput.fromString(e.getActionCommand)

        gameLogic     = gameLogic.isUserInputCorrect(userInput)

        mainGameLoop
    }

    private def initComponents: Unit = {
        setResizable(false)

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        val layout = new GroupLayout(getContentPane())

        getContentPane().setLayout(layout)

        GameLayoutUtility.setLayoutAttributes(layout, uiElements)

        pack()
    }

}
