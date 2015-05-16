package com.ui

import javax.swing.JPanel

import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.GroupLayout.LEADING

class RightPanel extends JPanel {

    setBackground(java.awt.Color.white)

    val rightPanelLayout = new GroupLayout(this)

    setLayout(rightPanelLayout)

    rightPanelLayout.setHorizontalGroup(
        rightPanelLayout.createParallelGroup(LEADING).add(0, 0, Short.MaxValue))

    rightPanelLayout.setVerticalGroup(
        rightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(0, 381, Short.MaxValue));

    
}
