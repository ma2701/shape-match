package com

/**
 * count down clock that at each tick goes back a second and stops at 0:0
 */
case class CountDownClock(minute: Int, second: Int) {

    def tick: CountDownClock = {
        val sec = if ((second - 1) == -1) 0 else second - 1
        val min = if (sec == 59)
            if ((minute - 1) == -1) 0 else minute - 1
        else minute

        CountDownClock(min, sec)
    }

    def hasExpired: Boolean = this == CountDownClock(0, 0)

    override def toString: String = s"${minute}:${second}"
}
