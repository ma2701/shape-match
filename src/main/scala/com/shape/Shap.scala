package com.shape

import java.awt.image.BufferedImage
import java.awt.{Graphics, Point}

import com.ImageCache


sealed abstract class Shape(val topLeft: Point) {
    def shapeImageName: String

    def moveTo(loc: Point): Shape

    val imageCache = new ImageCache()

    val image: BufferedImage =
        imageCache.loadOrThrow(shapeImageName)

    def draw(graphics: Graphics): Unit =
        graphics.drawImage(image, topLeft.x, topLeft.y, null)

    override def toString: String =
        s"${this.getClass.getSimpleName}at X:${topLeft.x} Y:${topLeft.y}"
}

case class HollowSquare(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowSquare.png"

    override def moveTo(loc: Point): Shape = HollowSquare(loc)
}

case class SolidSquare(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/solidSquare.png"

    override def moveTo(loc: Point): Shape = SolidSquare(loc)
}

case class HollowCircle(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowCircle.png"

    override def moveTo(loc: Point): Shape = HollowCircle(loc)
}

case class SolidCircle(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/solidCircle.png"

    override def moveTo(loc: Point): Shape = SolidCircle(loc)
}

case class HollowTriangle(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowTriangle.png"

    override def moveTo(loc: Point): Shape = HollowTriangle(loc)
}

case class SolidTriangle(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/solidTriangle.png"

    override def moveTo(loc: Point): Shape = SolidTriangle(loc)
}

case class HollowCross(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowCross.png"

    override def moveTo(loc: Point): Shape = HollowCross(loc)
}

case class SolidCross(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/solidCross.png"

    override def moveTo(loc: Point): Shape = SolidCross(loc)
}

case class ReverseL(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/reverseL.png"

    override def moveTo(loc: Point): Shape = ReverseL(loc)
}

case class InvertedL(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/invertedL.png"

    override def moveTo(loc: Point): Shape = InvertedL(loc)
}

case class FourSquare(location: Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/fourSquare.png"

    override def moveTo(loc: Point): Shape = FourSquare(loc)
}

