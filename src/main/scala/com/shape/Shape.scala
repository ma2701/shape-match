package com.shape

import java.awt.image.BufferedImage
import java.awt.{Graphics, Point}

import com.ImageCache

abstract class Shape(val topLeft: Point) {
    def shapeImageName:String
    def moveTo(loc: Point): Shape

    val imageCache = new ImageCache()

    val image: BufferedImage = imageCache.loadOrThrow(shapeImageName)

    def draw(graphics: Graphics): Unit =
        graphics.drawImage(image, topLeft.x, topLeft.y, null)

    override def toString:String = s"${this.getClass.getSimpleName}at X:${topLeft.x} Y:${topLeft.y}"

}