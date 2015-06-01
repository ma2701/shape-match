package com.ui.panel

import javax.swing.JPanel

import org.jdesktop.layout.GroupLayout

class GameStartPanel extends JPanel {


    initComponents

    private def initComponents: Unit = {

        val gameStartPanelLayout = new GroupLayout(this)

        setLayout(gameStartPanelLayout)

        gameStartPanelLayout.setHorizontalGroup(
            gameStartPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 649, Short.MaxValue)
        )
        gameStartPanelLayout.setVerticalGroup(
            gameStartPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 432, Short.MaxValue)
        )
    }

    
}
