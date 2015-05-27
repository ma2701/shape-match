package com.ui.panel

import javax.swing.JPanel

import com.GameLevel
import com.ui.TopPanelElements

class TopPanel extends JPanel {

    val uiElements            = TopPanelElements.default(this)

    initComponents

    def setCurrentStats(gameLevel: GameLevel, points:Int): TopPanel = {
        uiElements.statusPanel.setCurrentStats(gameLevel, points)
        this
    }

    def updateGameLevelText: Unit = {
        uiElements.statusPanel.repaint()
    }

    private def initComponents: Unit = {

        val timerPanelLayout = new org.jdesktop.layout.GroupLayout(this);
        setLayout(timerPanelLayout);
        timerPanelLayout.setHorizontalGroup(
            timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, timerPanelLayout.createSequentialGroup()
                                                           .add(uiElements.statusPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .add(204, 204, 204)
                                                           .add(uiElements.countdownTimerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue))
        )
        timerPanelLayout.setVerticalGroup(
            timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(timerPanelLayout.createSequentialGroup()
                 .add(timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                      .add(uiElements.countdownTimerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)
                      .add(org.jdesktop.layout.GroupLayout.TRAILING, uiElements.statusPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue))
                 .addContainerGap())
        )
    }


}
