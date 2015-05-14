package com

import org.scalatest.FunSuite

class CountDownTimerTest extends FunSuite {
    val ticksInMillis: Int = 1 // every timer tick is 1 ms

    test("can create an instance of countdown timer") {
        val timer = new CountDownTimer(10)

    }

    test("given a timer then start() will start the countdown timer") {
        val timer = new CountDownTimer(10, ticksInMillis).start { i:Int =>
            Unit
        }
    }

    test("given a timer then start() will call the function n times") {
        var actualNumberOfCalls = 0
        val expectedNumberOfCalls= 10

        new CountDownTimer(expectedNumberOfCalls,ticksInMillis).start { i:Int =>
            actualNumberOfCalls += 1
        }

        assert( actualNumberOfCalls === expectedNumberOfCalls)
    }

}
