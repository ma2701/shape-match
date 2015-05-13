package com

import com.util.random.RandomNumberGenerator

object ShapeSelector {
    private val shapes = Seq( new Square, new Circle)

    def select(level: GameLevel): Seq[Shape] = {
        RandomNumberGenerator.nextNNumbers(level.shapeCount, shapes.indices).map(shapes(_))
    }

   def selectOneRandomShape: Shape =
       shapes(
           RandomNumberGenerator.next(0 to (shapes.size-1))
       )
    }
