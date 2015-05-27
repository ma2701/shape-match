package com.ui

import java.awt.Color._
import java.awt.{Dimension, Font}
import javax.swing.JButton

import com.DisplayWindow
import com.ui.panel.{TopPanel, RightShapePanel, LeftShapePanel}

object UIElements {
    val buttonFont = new Font("Arial", 1, 15)

    def default(shapeMatchFrame: ShapeMatchFrame):UIElements =
         UIElements(
             new Button(shapeMatchFrame, GREEN, BLACK, buttonFont, "MATCH"),
             new Button(shapeMatchFrame, RED, BLACK, buttonFont, "MISMATCH"),
             new RightShapePanel,
             new LeftShapePanel,
             new TopPanel)


}

case class UIElements(matchButton: JButton,
                      noMatchButton: JButton,
                      rightPanel: RightShapePanel,
                      leftPanel: LeftShapePanel,
                      topPanel: TopPanel) {

    def displayWindow : DisplayWindow =
        new DisplayWindow(new Dimension(leftPanel.getWidth, leftPanel.getHeight))

}
