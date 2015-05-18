package com.ui

import java.awt.Color._
import java.awt.Font
import javax.swing.JButton

object UIElements {
    val buttonFont = new Font("Arial", 1, 15)

    def default(shapeMatchFrame: ShapeMatchFrame):UIElements =
         UIElements(
             new Button(shapeMatchFrame, GREEN, buttonFont , BLACK, "MATCH" ),
             new Button(shapeMatchFrame, RED, buttonFont, BLACK, "MISMATCH" ),
             new RightPanel, new LeftPanel,  new TimerPanel)

}

case class UIElements(matchButton: JButton,
                      noMatchButton: JButton,
                      rightPanel: RightPanel,
                      leftPanel: LeftPanel,
                      timerPanel: TimerPanel)
