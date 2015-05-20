package com

import com.ui.CountdownTimerPanel

class GameTimer(val timerPanel: CountdownTimerPanel) extends Runnable {

    private[this] var minuteClock :    CountDownClock = CountDownClock(1,30)

    private[this] var currentTime = 60


    override def run(): Unit = {
        do {

            Thread.sleep(1000)

            minuteClock = minuteClock.tick

            timerPanel.setTime(minuteClock.toString).updateTime

        } while(currentTime >= 0 )
    }

    def getCurrentTime:Int  = currentTime

}
