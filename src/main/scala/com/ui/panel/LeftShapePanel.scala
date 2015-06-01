package com.ui.panel

import com.ui.ShapeMatchFrame
import org.jdesktop.layout.GroupLayout.LEADING

class LeftShapePanel extends ShapeMatchPanel {

    def initComponents: Unit = {
        setBackground(ShapeMatchFrame.mainUIColor)

        val leftShapePanelLayout = new org.jdesktop.layout.GroupLayout(this)
        setLayout(leftShapePanelLayout)
        leftShapePanelLayout.setHorizontalGroup(
            leftShapePanelLayout.createParallelGroup(LEADING)
            .add(0, 293, Short.MaxValue))

        leftShapePanelLayout.setVerticalGroup(
            leftShapePanelLayout.createParallelGroup(LEADING)
            .add(0, 429, Short.MaxValue)
        )
    }
}
