package com

import java.awt.Point
import java.awt.image.BufferedImage

case class Square(location:Point = new Point) extends Shape(location) {
    override val image: BufferedImage = imageCache.loadOrThrow("/hollowSquare.png")

    override def moveTo(loc: Point): Shape = Square(loc)

    override def toString:String = s"Square at X:${location.x} Y:${location.y}"
}

case class Circle(location:Point = new Point) extends Shape(location) {

    override val image: BufferedImage = imageCache.loadOrThrow("/hollowCircle.png")

    override def moveTo(loc: Point): Shape = Circle(loc)

    override def toString:String = s"Circle at X:${location.x} Y:${location.y}"
}

