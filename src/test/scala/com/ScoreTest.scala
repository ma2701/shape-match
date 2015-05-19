package com

import org.scalatest.FunSuite

class ScoreTest extends FunSuite {

    test("given current score when correct answer given then points added to teh current score") {
        val score = Score(10)

        assert( 20 ===  score.add(10).points)
    }

    test("given current score when incorrect answer given then points deducted") {
        val score = Score(10)

        assert( 0 ===  score.deduct(10).points)
    }
}
