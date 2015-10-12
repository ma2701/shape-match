package com.ui.panel

import java.awt.Color
import javax.swing._

import com.DisplayGrid
import com.ui.{GameLayoutUtility, LayeredPaneElements, ShapeMatchFrame}
import org.jdesktop.layout.GroupLayout

class LayeredPane extends JLayeredPane {
    
    val uiElements = LayeredPaneElements.default

    val rootPaneLayout = new GroupLayout(this)

    initComponents

    def displayShapePanels: Unit = {
        uiElements.finalScorePanel.setVisible(false)
        uiElements.rightShapePanel.setVisible(true)
        uiElements.leftShapePanel.setVisible(true)
    }

    def displayFinalScore: Unit = {
        uiElements.leftShapePanel.setVisible(false)
        uiElements.rightShapePanel.setVisible(false)
        uiElements.finalScorePanel.setVisible(true)
    }

    def drawShapeInRightShapePanel(disGrid: DisplayGrid): Unit = {
        uiElements.rightShapePanel.drawShapes(disGrid)
    }

    def drawShapeInLeftShapePanel(disGrid: DisplayGrid): Unit = {
        uiElements.leftShapePanel.drawShapes(disGrid)
    }

    def addMainFrameAsActionListener(shapeMatchFrame: ShapeMatchFrame): Unit =
        uiElements.finalScorePanel.addMainGameFrameAsActionListener(shapeMatchFrame)

    private def initComponents: Unit = {
        setBackground(Color.RED)

        setLayout(rootPaneLayout)

        GameLayoutUtility.setMainLayeredPaneAttributes(rootPaneLayout, uiElements)

        displayShapePanels

        uiElements.gameStartPanel.setVisible(false)
        uiElements.finalScorePanel.setVisible(false)
    }

}
