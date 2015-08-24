package com.ui

import org.jdesktop.layout.GroupLayout
import org.jdesktop.layout.GroupLayout._

object GameLayoutUtility {

    def setMainFrameLayoutAttributes(layout: GroupLayout, elements: UIElements): Unit = {

        layout.setHorizontalGroup(
            layout.createParallelGroup(LEADING)
            .add(TRAILING, layout.createSequentialGroup()
                           .addContainerGap(DEFAULT_SIZE, Short.MaxValue)
                           .add(elements.matchButton, PREFERRED_SIZE, 121, PREFERRED_SIZE)
                           .add(10, 10, 10)
                           .add(elements.mismatchButton, PREFERRED_SIZE, 121, PREFERRED_SIZE)
                           .add(214, 214, 214))
            .add(layout.createSequentialGroup()
                 .addContainerGap()
                 .add(elements.layeredPane)
                 .addContainerGap())
            .add(layout.createParallelGroup(LEADING)
                 .add(layout.createSequentialGroup()
                      .addContainerGap()
                      .add(elements.topPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MaxValue)
                      .addContainerGap()))
        )

        layout.setVerticalGroup(
            layout.createParallelGroup(LEADING)
            .add(layout.createSequentialGroup()
                 .addContainerGap(130, Short.MaxValue)
                 .add(elements.layeredPane, PREFERRED_SIZE, 453, PREFERRED_SIZE)
                 .add(18, 18, 18)
                 .add(layout.createParallelGroup(BASELINE)
                      .add(elements.matchButton, PREFERRED_SIZE, 50, PREFERRED_SIZE)
                      .add(elements.mismatchButton, PREFERRED_SIZE, 50, PREFERRED_SIZE))
                 .add(49, 49, 49))
            .add(layout.createParallelGroup(LEADING)
                 .add(layout.createSequentialGroup()
                      .addContainerGap()
                      .add(elements.topPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                      .addContainerGap(572, Short.MaxValue)))
        )

    }

    def setMainLayeredPaneAttributes(rootPaneLayout: GroupLayout, elements: LayeredPaneElements): Unit = {

        rootPaneLayout.setHorizontalGroup(
            rootPaneLayout.createParallelGroup(LEADING)
            .add(rootPaneLayout.createSequentialGroup()
                 .add(elements.leftShapePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                 .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 72, Short.MaxValue)
                 .add(elements.rightShapePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
            .add(rootPaneLayout.createParallelGroup(LEADING)
                 .add(TRAILING, elements.gameStartPanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MaxValue))
            .add(rootPaneLayout.createParallelGroup(LEADING)
                 .add(elements.finalScorePanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MaxValue))
        )
        rootPaneLayout.setVerticalGroup(
            rootPaneLayout.createParallelGroup(LEADING)
            .add(TRAILING, rootPaneLayout.createSequentialGroup()
                           .addContainerGap(DEFAULT_SIZE, Short.MaxValue)
                           .add(rootPaneLayout.createParallelGroup(TRAILING)
                                .add(elements.rightShapePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .add(elements.leftShapePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                           .addContainerGap())
            .add(rootPaneLayout.createParallelGroup(LEADING)
                 .add(TRAILING, rootPaneLayout.createSequentialGroup()
                                .addContainerGap(DEFAULT_SIZE, Short.MaxValue)
                                .add(elements.gameStartPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap()))
            .add(rootPaneLayout.createParallelGroup(LEADING)
                 .add(rootPaneLayout.createSequentialGroup()
                      .add(87, 87, 87)
                      .add(elements.finalScorePanel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MaxValue)
                      .addContainerGap()))
        )
    }


}
