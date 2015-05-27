package com.ui.panel

import java.awt.Graphics
import javax.swing.JPanel

import com.{Cell, DisplayGrid}

abstract class ShapeMatchPanel extends JPanel {

    protected[this] var shapesToBeDisplayed: Seq[Seq[Cell]] = Nil

    initComponents

    protected def initComponents:Unit

    def drawShapes(displayGrid: DisplayGrid):Unit = {
        shapesToBeDisplayed = displayGrid.cells

        this.repaint()
    }

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        shapesToBeDisplayed.foreach (
            row =>
                row.foreach(
                    col =>
                        col.shape.map(_.draw(g))
            )
        )
    }
}
