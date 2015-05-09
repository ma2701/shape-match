package com

import com.util.random.RandomNumberGenerator

object ShapeSelector {
    private val shapes = Seq( new Square )

    def select(level: GameLevel): Seq[Shape] = {
        RandomNumberGenerator.nextNNumbers(level.shapeCount, shapes.indices).map( shapes(_))
    }


}
