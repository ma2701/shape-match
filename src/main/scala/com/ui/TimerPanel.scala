package com.ui

import javax.swing.JPanel

class TimerPanel extends JPanel {

    val  timerPanelLayout = new org.jdesktop.layout.GroupLayout(this)

    setLayout(timerPanelLayout);

    timerPanelLayout.setHorizontalGroup(
        timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(0, 0, Short.MaxValue))

    timerPanelLayout.setVerticalGroup(
        timerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(0, 126, Short.MaxValue))


}
