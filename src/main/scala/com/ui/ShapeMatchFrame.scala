package com.ui

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JFrame

import com.{GameLogic, UserInput}
import org.jdesktop.layout.GroupLayout

class ShapeMatchFrame extends JFrame with Runnable with ActionListener {

    private[this] val uiElements            = UIElements.default(this)
    private[this] var gameThread: Thread    = _
    private[this] var gameLogic : GameLogic = new GameLogic

    initComponents

    override def addNotify: Unit = {
        super.addNotify()

        gameThread = new Thread(this)
        gameThread.start()
    }

    override def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = {

        uiElements.rightPanel.drawShapes(gameLogic.shapesPair.right)

        uiElements.leftPanel.drawShapes(gameLogic.shapesPair.left)

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
