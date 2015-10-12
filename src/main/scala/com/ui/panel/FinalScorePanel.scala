package com.ui.panel

import java.awt.event.{ActionEvent, ActionListener}
import java.awt._
import javax.swing.JPanel

import com.{ApplicationDeath, UserInput}
import com.ui.ShapeMatchFrame
import org.jdesktop.layout.GroupLayout

class FinalScorePanel extends JPanel {
    private[this] var finalScore: Option[Int] = None
    private lazy val finalScoreLocation = new Point((getWidth/2)-62, 30)

    private[this] val fontSize               = 16
    private[this] val font                   = new Font("TimesRoman", Font.BOLD, fontSize)
    private[this] val statsTextColour        = ShapeMatchFrame.mainUIColor
    private[this] val continueButton        = new javax.swing.JButton()
    private[this] val quitButton            = new javax.swing.JButton()

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
        continueButton.setText("Continue")
        quitButton.setText("Quit")

        val scorePanelLayout = new GroupLayout(this)

        setLayout(scorePanelLayout)

        scorePanelLayout.setHorizontalGroup(
            scorePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, scorePanelLayout.createSequentialGroup()
                                                           .addContainerGap(169, Short.MaxValue)
                                                           .add(continueButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .add(116, 116, 116)
                                                           .add(quitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .addContainerGap(181, Short.MaxValue))
        )
        scorePanelLayout.setVerticalGroup(
            scorePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scorePanelLayout.createSequentialGroup()
                 .addContainerGap(263, Short.MaxValue)
                 .add(scorePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                      .add(quitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                      .add(continueButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MaxValue))
                 .addContainerGap(73, Short.MaxValue))
        )
    }

    def addMainGameFrameAsActionListener(shapeMatchFrame: ShapeMatchFrame): Unit = {
        continueButton.addActionListener(shapeMatchFrame)
        quitButton.addActionListener(shapeMatchFrame)
    }
}
