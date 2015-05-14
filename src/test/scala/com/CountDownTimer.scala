package com

class CountDownTimer(seconds: Int, timerTick: Int = 1000) {

    def start(displayFunction : Int => Unit ): Unit = {
        (seconds to 1 by -1).foreach { second =>

            displayFunction(second)

            try {
                Thread.sleep(timerTick)
            } catch {
                case e:InterruptedException => println("exception while sleeping in count down timer method")
            }
        }
    }
}
