package com.ui.panel

import java.awt.{Font, Graphics, Point}
import javax.swing.JPanel

import com.ui.ShapeMatchFrame
import org.jdesktop.layout.GroupLayout

class CountdownTimerPanel extends JPanel {

    private[this] var time: String = ""
    private[this] val font = Font.createFont(Font.TRUETYPE_FONT, getClass.getResourceAsStream("/fonts/digital-7.ttf") )
                             .deriveFont(Font.BOLD, 80)
    private[this] val timerColor = ShapeMatchFrame.mainUIColor
    private[this] val clockLocation = new Point(0, 80)

    initComponents


    def setTime(timeInStringFormat:String): CountdownTimerPanel = {
        this.time = timeInStringFormat
        this
    }

    def updateTime: Unit = {
        repaint()
    }

    override def paintComponent(g:Graphics): Unit = {

        super.paintComponent(g)
        g.setFont(font)
        g.setColor(timerColor)

        g.drawString(s"${time}",clockLocation.x, clockLocation.y )
    }

    private def initComponents: Unit = {


        val CountdownTimerPanelLayout = new GroupLayout(this)
        setLayout(CountdownTimerPanelLayout)

        CountdownTimerPanelLayout.setHorizontalGroup(
            CountdownTimerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MaxValue)
        )

        CountdownTimerPanelLayout.setVerticalGroup(
            CountdownTimerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 115, Short.MaxValue)
        )
    }

    
}
