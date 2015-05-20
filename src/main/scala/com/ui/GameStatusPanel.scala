package com.ui

import java.awt._
import javax.swing.JPanel

import com.{GameLevel, LevelOne}
import org.jdesktop.layout.GroupLayout

class GameStatusPanel extends JPanel{

    private[this] var currentLevel:GameLevel = LevelOne
    private[this] var currentPoints:Int      = 0
    private[this] var correctAnswer:Boolean  = true
    private[this] val currentLevelPosition   = new Point(10,40)
    private[this] val currentPointsPosition  = new Point(currentLevelPosition.x, currentLevelPosition.y + 40)

    private[this] val statsTextColour        = new Color(25, 25, 112)
    private[this] val scoreTextColourCorrect = new Color(0,128,0)
    private[this] val scoreTextColourWrong   = new Color(255,0,0)
    private[this] val fontSize               = 14
    private[this] val font                   = new Font("TimesRoman", Font.PLAIN, fontSize)

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
        g.drawString(s"Current Level: ${currentLevel}", currentLevelPosition.x, currentLevelPosition.y)

        if(correctAnswer) {
            g.setColor(scoreTextColourCorrect)
            g.drawString(s"Score : ${currentPoints}", currentPointsPosition.x, currentPointsPosition.y)
        } else {
            g.setColor(scoreTextColourWrong)
            g.drawString(s"Score : ${currentPoints}", currentPointsPosition.x, currentPointsPosition.y)
        }

    }

    private def initComponents: Unit = {
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED))

        val gameStatusPanelLayout = new GroupLayout(this)
        setLayout(gameStatusPanelLayout)
        gameStatusPanelLayout.setHorizontalGroup(
            gameStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 199, Short.MaxValue)
        )
        gameStatusPanelLayout.setVerticalGroup(
            gameStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 113, Short.MaxValue)
        )
    }


}
