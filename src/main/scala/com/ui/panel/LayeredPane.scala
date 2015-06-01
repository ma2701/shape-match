package com.ui.panel

import java.awt.Color
import javax.swing._

import com.ui.{GameLayoutUtility, LayeredPaneElements}
import org.jdesktop.layout.GroupLayout

class LayeredPane extends JLayeredPane {
    
    val uiElements = LayeredPaneElements.default

    val rootPaneLayout = new GroupLayout(this)

    initComponents

    def displayShapePanels:Unit = {
        uiElements.rightShapePanel.setVisible(true)
        uiElements.leftShapePanel.setVisible(true)
    }

     def displayFinalScore:Unit = {
         uiElements.leftShapePanel.setVisible(false)
         uiElements.rightShapePanel.setVisible(false)
         uiElements.finalScorePanel.setVisible(true)
     }


    private def initComponents: Unit = {
        setBackground(Color.RED)

        setLayout(rootPaneLayout)

        GameLayoutUtility.setMainLayeredPaneAttributes(rootPaneLayout, uiElements)

        displayShapePanels

        uiElements.gameStartPanel.setVisible(false)
        uiElements.finalScorePanel.setVisible(false)
    }

}
