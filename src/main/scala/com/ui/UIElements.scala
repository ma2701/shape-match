package com.ui

import java.awt.Color._
import java.awt.{Dimension, Font}
import javax.swing.JButton

import com.DisplayWindow

object UIElements {
    val buttonFont = new Font("Arial", 1, 15)

    def default(shapeMatchFrame: ShapeMatchFrame):UIElements =
         UIElements(
             new Button(shapeMatchFrame, GREEN, buttonFont , BLACK, "MATCH" ),
             new Button(shapeMatchFrame, RED, buttonFont, BLACK, "MISMATCH" ),
             new RightPanel,
             new LeftPanel,
             new TopPanel)


}

case class UIElements(matchButton: JButton,
                      noMatchButton: JButton,
                      rightPanel: RightPanel,
                      leftPanel: LeftPanel,
                      topPanel: TopPanel) {

    def displayWindow : DisplayWindow =
        new DisplayWindow(new Dimension(leftPanel.getWidth, leftPanel.getHeight))

}
