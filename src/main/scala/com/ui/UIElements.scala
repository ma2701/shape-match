package com.ui

import java.awt.Color._
import java.awt.event.ActionListener
import java.awt.{Dimension, Font}
import javax.swing.JButton

import com.DisplayWindow
import com.ui.panel.{LayeredPane, TopPanel}

object UIElements {
    val buttonFont = new Font("Arial", 1, 15)

    def default:UIElements =
         UIElements(
             new Button(GREEN, BLACK, buttonFont, "MATCH"),
             new Button(RED, BLACK, buttonFont, "MISMATCH"),
             new LayeredPane,
             new TopPanel)


}

case class UIElements(matchButton: Button,
                      mismatchButton: Button,
                      layeredPane: LayeredPane,
                      topPanel: TopPanel) {

    def displayWindow : DisplayWindow =
        new DisplayWindow(new Dimension(layeredPane.uiElements.leftShapePanel.getWidth, layeredPane.uiElements.leftShapePanel.getHeight))

    def addMatchActionListener(actionListener:ActionListener):Unit = {
        matchButton.actionListener(actionListener)
    }
    
    def addMismatchActionListener(actionListener:ActionListener):Unit = {
        mismatchButton.actionListener(actionListener)
    }

}
