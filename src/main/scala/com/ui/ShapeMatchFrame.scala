package com.ui

import java.awt.{Color, Font}
import javax.swing.{JButton, JFrame}

import org.jdesktop.layout.GroupLayout

class ShapeMatchFrame extends JFrame {

    setResizable(false)

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    val matchButton = new JButton()
    val noMatchButton = new JButton()
    val rightPanel    = new RightPanel
    val leftPanel     = new LeftPanel
    val timerPanel    = new TimerPanel


    matchButton.setBackground(java.awt.Color.green)
    matchButton.setFont(new Font("Arial", 1, 15)) // NOI18N
    matchButton.setForeground(Color.BLACK)
    matchButton.setText("Match")

    noMatchButton.setBackground(java.awt.Color.red)
    noMatchButton.setFont(new Font("Arial", 1, 15)) // NOI18N
    noMatchButton.setForeground(Color.BLACK)
    noMatchButton.setText("No Match")

    initComponents

    pack()

    private def initComponents: Unit = {
        val layout = new GroupLayout(getContentPane())

        getContentPane().setLayout(layout)

        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                           .add(33, 33, 33)
                                                           .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                                .add(timerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)
                                                                .add(layout.createSequentialGroup()
                                                                     .add(leftPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                     .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                                     .add(rightPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)))
                                                           .add(35, 35, 35))

            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                           .addContainerGap(198, Short.MaxValue)
                                                           .add(matchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                           .add(noMatchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .add(199, 199, 199)))

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                 .addContainerGap()
                 .add(timerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                 .add(18, 18, 18)
                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                      .add(rightPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)
                      .add(leftPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue))
                 .add(28, 28, 28)
                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                      .add(noMatchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                      .add(matchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(22, Short.MaxValue)))
    }


}
