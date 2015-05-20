package com.ui

import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.GroupLayout.LEADING

class RightPanel extends ShapeMatchPanel {

    def initComponents: Unit = {
        setBackground(new java.awt.Color(33, 21, 21))

        val rightPanelLayout = new GroupLayout(this)

        setLayout(rightPanelLayout)

        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(LEADING).add(0, 0, Short.MaxValue))

        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 381, Short.MaxValue));
    }
}
