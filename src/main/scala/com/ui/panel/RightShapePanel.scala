package com.ui.panel

import java.awt.Color

import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.GroupLayout.LEADING

class RightShapePanel extends ShapeMatchPanel {

    def initComponents: Unit = {

        setBackground(Color.BLACK)

        val rightPanelLayout = new GroupLayout(this)

        setLayout(rightPanelLayout)

        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(LEADING).add(0, 0, Short.MaxValue))

        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 381, Short.MaxValue));
    }
}
