package com.ui.panel

import java.awt.{Font, Color, Point, Graphics}
import javax.swing.JPanel

import com.ui.ShapeMatchFrame
import org.jdesktop.layout.GroupLayout

class FinalScorePanel extends JPanel {
    private[this] var finalScore: Option[Int] = None
    private lazy val finalScoreLocation = new Point((getWidth/2)-62, 30)

    private[this] val fontSize               = 16
    private[this] val font                   = new Font("TimesRoman", Font.BOLD, fontSize)
    private[this] val statsTextColour        = ShapeMatchFrame.mainUIColor

    initComponents


    override def paintComponent(g:Graphics ): Unit = {
        super.paintComponent(g)

        if(finalScore.isDefined) {
            g.setColor(statsTextColour)
            g.setFont(font)

            g.drawString(s"Final Score: ${finalScore.get}", finalScoreLocation.x , finalScoreLocation.y)
        }
    }

    def setFinalScore(fs:Int) : FinalScorePanel = {
        finalScore = Some(fs)
        this
    }

    private def initComponents: Unit = {
        val scorePanelLayout = new GroupLayout(this)

        setLayout(scorePanelLayout)

        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 649, Short.MaxValue)
        )
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 432, Short.MaxValue)
        )
    }

    
}
