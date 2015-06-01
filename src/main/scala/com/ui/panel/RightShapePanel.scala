package com.ui.panel

import com.ui.ShapeMatchFrame._
import org.jdesktop.layout.GroupLayout.LEADING

class RightShapePanel extends ShapeMatchPanel {

    def initComponents: Unit = {

        setBackground(mainUIColor)

        val  rightShapePanelLayout = new org.jdesktop.layout.GroupLayout(this)

        setLayout(rightShapePanelLayout)

        rightShapePanelLayout.setHorizontalGroup(
            rightShapePanelLayout.createParallelGroup(LEADING)
            .add(0, 292, Short.MaxValue))

        rightShapePanelLayout.setVerticalGroup(
            rightShapePanelLayout.createParallelGroup(LEADING)
            .add(0, 429, Short.MaxValue))

    }
}
