package com

import java.awt.image.BufferedImage
import java.awt.{Graphics, Point}

abstract class Shape(val topLeft: Point) {
    val imageCache = new ImageCache()

    val image:BufferedImage

    def draw(graphics: Graphics): Unit =
        graphics.drawImage(image, topLeft.x, topLeft.y, null)

    def moveTo(loc: Point): Shape

}