package com.shape

import java.awt.Point

case class HollowSquare(location:Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowSquare.png"

    override def moveTo(loc: Point): Shape = HollowSquare(loc)
}

case class SolidSquare(location:Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/solidSquare.png"

    override def moveTo(loc: Point): Shape = HollowSquare(loc)
}

case class HollowCircle(location:Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowCircle.png"

    override def moveTo(loc: Point): Shape = HollowCircle(loc)
}

case class SolidCircle(location:Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/solidCircle.png"

    override def moveTo(loc: Point): Shape = SolidCircle(loc)
}

case class HollowTriangle(location:Point = new Point) extends Shape(location) {
    override def shapeImageName: String = "/hollowTriangle.png"

    override def moveTo(loc: Point): Shape = HollowTriangle(loc)
}

