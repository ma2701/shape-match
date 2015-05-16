package com.ui

import javax.swing.JPanel
import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.GroupLayout.LEADING

class LeftPanel extends JPanel {

    setBackground(java.awt.Color.white)

    val leftPanelLayout = new GroupLayout(this);

    setLayout(leftPanelLayout)

    leftPanelLayout.setHorizontalGroup(
        leftPanelLayout.createParallelGroup(GroupLayout.LEADING)
        .add(0, 286, Short.MaxValue))

    leftPanelLayout.setVerticalGroup(
        leftPanelLayout.createParallelGroup(LEADING)
        .add(0, 0, Short.MaxValue))


}
