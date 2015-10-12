package com.ui

import java.awt.{EventQueue, Color}
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JFrame

import com._
import org.jdesktop.layout.GroupLayout

object ShapeMatchFrame {
    val mainUIColor = new Color(0, 0, 0)
}

class ShapeMatchFrame(testGame: Game,
                      uiElements: UIElements,
                      timerThread: Thread) extends JFrame with Runnable with ActionListener with TimerExpirySubscriber {

    private[this] var gameThread: Thread = _

    initComponents

    override def addNotify: Unit = {
        super.addNotify()

        gameThread = new Thread(this)
        gameThread.start()

        timerThread.start()
    }

    override def run(): Unit = mainGameLoop

    private def mainGameLoop: Unit = testGame.updateUI

    override def actionPerformed(e: ActionEvent): Unit =
        e.getActionCommand.toLowerCase match {
            case "mismatch" | "match" => testGame.processUserInput(UserInput.fromString(e.getActionCommand))
            case "continue" => testGame.handleGameContinue
            case "quit"     => testGame.handleGameQuit
            case _ => Unit
        }


    private def initComponents: Unit = {
        setResizable(false)

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        val layout = new GroupLayout(getContentPane())

        getContentPane().setLayout(layout)

        GameLayoutUtility.setMainFrameLayoutAttributes(layout, uiElements)

        pack()
    }

    override def timerHasExpired: Unit = testGame.handelTimerExpiry
}
