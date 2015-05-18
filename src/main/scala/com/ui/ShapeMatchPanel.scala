package com.ui

import java.awt.Graphics
import javax.swing.JPanel

import com.Shape

abstract class ShapeMatchPanel extends JPanel {

    protected[this] var shapesToBeDisplayed: Seq[Shape] = Nil

    initComponents

    protected def initComponents:Unit

    def drawShapes(shapes: Seq[Shape]):Unit = {
        this.shapesToBeDisplayed = shapes

        this.repaint()
    }

    override def paintComponent(g: Graphics): Unit = {
        super.paintComponent(g)

        shapesToBeDisplayed.foreach( _.draw(g))
    }
}
