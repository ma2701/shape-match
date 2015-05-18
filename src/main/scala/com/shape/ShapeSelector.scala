package com.shape

import com.GameLevel
import com.util.random.RandomNumberGenerator

object ShapeSelector {

    private val shapes = Seq(
        new ReverseL,
        new HollowSquare,
        new SolidSquare,
        new HollowCircle,
        new SolidCircle,
        new HollowTriangle,
        new SolidTriangle,
        new HollowCross,
        new SolidCross,
        new InvertedL,
        new FourSquare
    )

    def select(level: GameLevel): Seq[Shape] =
        RandomNumberGenerator.nextNNumbers(level.shapeCount, shapes.indices).map(shapes(_))

   def selectOneRandomShape: Shape =
       shapes(
           RandomNumberGenerator.next(0 to (shapes.size-1))
       )
    }
