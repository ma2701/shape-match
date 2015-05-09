package com

import java.awt.{Graphics, Point}

case class Square(location:Point = new Point) extends Shape {

    override def draw(graphics: Graphics): Unit = Unit

}

