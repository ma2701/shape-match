package com.ui

import org.jdesktop.layout.GroupLayout

object GameLayoutUtility {

    def setLayoutAttributes(layout: GroupLayout, elements: UIElements ):Unit = {

        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                           .add(33, 33, 33)
                                                           .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                                .add(elements.timerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)
                                                                .add(layout.createSequentialGroup()
                                                                     .add(elements.leftPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                     .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                                     .add(elements.rightPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)))
                                                           .add(35, 35, 35))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                           .addContainerGap(198, Short.MaxValue)
                                                           .add(elements.matchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                                           .add(elements.noMatchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                           .add(199, 199, 199)))

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                 .addContainerGap()
                 .add(elements.timerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                 .add(18, 18, 18)
                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                      .add(elements.rightPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue)
                      .add(elements.leftPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MaxValue))
                 .add(28, 28, 28)
                 .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                      .add(elements.noMatchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                      .add(elements.matchButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(22, Short.MaxValue)))

    }


}
