package com

import java.awt.{Graphics, Point}

case class Square(location:Point = new Point) extends Shape(location) {

    override def draw(graphics: Graphics): Unit = Unit

    override def toString:String = s"Square at X:${location.x} Y:${location.y}"

    override def moveTo(loc: Point): Shape = Square(loc)

}

case class Circle(location:Point = new Point) extends Shape(location) {

    override def draw(graphics: Graphics): Unit = Unit

    override def toString:String = s"Circle at X:${location.x} Y:${location.y}"

    override def moveTo(loc: Point): Shape = Circle(loc)
}

