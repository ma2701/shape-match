package com

case class CountDownClock(minute: Int, second: Int) {

    def tick: CountDownClock =
        if (minute == 0 && second == 0)
            CountDownClock(0, 0)
        else {
            val sec =
                if ((second - 1) == -1) 59
                else second - 1

            val min =
                if (sec == 59)
                    if ((minute - 1) == -1) 59
                    else minute - 1
                else minute

            CountDownClock(min, sec)
        }

    def hasExpired: Boolean = this == CountDownClock(0, 0)

    override def toString: String = s"${minute}:${second}"
}
