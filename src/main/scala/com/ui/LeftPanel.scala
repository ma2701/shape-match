package com.ui

import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.GroupLayout.LEADING

class LeftPanel extends ShapeMatchPanel {

    def initComponents: Unit = {
        setBackground(new java.awt.Color(33, 21, 21))

        val leftPanelLayout = new GroupLayout(this)

        setLayout(leftPanelLayout)

        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(GroupLayout.LEADING)
            .add(0, 286, Short.MaxValue))

        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(LEADING)
            .add(0, 0, Short.MaxValue))
    }
}
