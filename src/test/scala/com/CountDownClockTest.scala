package com

import org.scalatest.FunSuite

class CountDownClockTest extends FunSuite {

    test("can create instance") {
        val clock = new CountDownClock(20,3)
    }

    test("given current time 22:33 then tick will update decrement seconds") {
        assert(CountDownClock(22, 32) === CountDownClock(22,33).tick)
    }

    test("given current time 22:0 then tick will stay at 21:59") {

        assert( CountDownClock(21, 59) ==  CountDownClock(22, 0).tick)
    }

    test("given current time 1:0 then tick will stay at 0:59") {
        assert( CountDownClock(0, 59) == new CountDownClock(1, 0).tick)
    }

    test("given current time 0:1 then tick will reset second") {
        assert( CountDownClock(0,0) == new CountDownClock(0, 1).tick)
    }

    test("given current time 0:0 then tick will reset both seconds and minutes") {
        assert( CountDownClock(0,0) == new CountDownClock(0, 1).tick.tick)
    }

    test("given current time 0:0 then we are out of time") {
        assert(new CountDownClock(0, 1).tick.hasExpired)
    }

    test("given time 1:10 then once tick will display 01:09") {
        assert("01:09" == new CountDownClock(1, 10).tick.toString)
    }
}
