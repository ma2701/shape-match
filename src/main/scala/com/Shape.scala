package com

import java.awt.{Point, Graphics}

abstract class Shape(val topLeft: Point) {
    def draw(graphics: Graphics): Unit

    def moveTo(loc: Point): Shape
}