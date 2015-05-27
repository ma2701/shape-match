package com.ui.panel

import java.awt._
import javax.swing.JPanel

import com.GameLevel
import com.ui.ShapeMatchFrame
import org.jdesktop.layout.GroupLayout

class GameStatusPanel extends JPanel{

    private[this] var currentLevel:GameLevel = GameLevel(1)
    private[this] var currentPoints:Int      = 0
    private[this] var correctAnswer:Boolean  = true
    private[this] val currentLevelPosition   = new Point(10,40)
    private[this] val currentPointsPosition  = new Point(currentLevelPosition.x, currentLevelPosition.y + 40)

    private[this] val statsTextColour        = ShapeMatchFrame.mainUIColor
    private[this] val scoreTextColourCorrect = ShapeMatchFrame.mainUIColor

    private[this] val scoreTextColourWrong   = new Color(255,0,0)
    private[this] val fontSize               = 16
    private[this] val font                   = new Font("TimesRoman", Font.BOLD, fontSize)

    initComponents

    def setCurrentStats(gameLevel: GameLevel, points:Int): GameStatusPanel = {
        currentLevel = gameLevel
        correctAnswer = points > currentPoints

        currentPoints = points

        this
    }

    def updateGameLevelText: Unit = {
        repaint()
    }

    override def paintComponent(g:Graphics): Unit = {
        super.paintComponent(g)
        g.setColor(statsTextColour)
        g.setFont(font)
        g.drawString(s"Level: ${currentLevel}", currentLevelPosition.x, currentLevelPosition.y)

        if(correctAnswer) {
            g.setColor(scoreTextColourCorrect)
            g.drawString(s"Score : ${currentPoints}", currentPointsPosition.x, currentPointsPosition.y)
        } else {
            g.setColor(scoreTextColourWrong)
            g.drawString(s"Score : ${currentPoints}", currentPointsPosition.x, currentPointsPosition.y)
        }

    }

    private def initComponents: Unit = {

        val gameStatusPanelLayout = new GroupLayout(this)
        setLayout(gameStatusPanelLayout)
        gameStatusPanelLayout.setHorizontalGroup(
            gameStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 200, Short.MaxValue)
        )
        gameStatusPanelLayout.setVerticalGroup(
            gameStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 113, Short.MaxValue)
        )
    }


}
