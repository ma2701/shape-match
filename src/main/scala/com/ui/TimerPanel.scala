package com.ui

import java.awt.Graphics
import javax.swing.JPanel

import com.GameLevel

class TimerPanel extends JPanel {

    private[this] var currentLevel:GameLevel =_

    def setCurrentGameLevel(gameLevel: GameLevel): TimerPanel = {
        currentLevel = gameLevel
        this
    }

    def updateGameLevelText: Unit = {
        repaint()
    }

    override def paintComponent(g:Graphics): Unit = {
        super.paintComponent(g)

        g.drawString(s"${currentLevel}", 20,10)
    }

    val  timerPanelLayout = new org.jdesktop.layout.GroupLayout(this)

    setLayout(timerPanelLayout);

    timerPanelLayout.setHorizontalGroup(
        timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(0, 0, Short.MaxValue))

    timerPanelLayout.setVerticalGroup(
        timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(0, 126, Short.MaxValue))


}
