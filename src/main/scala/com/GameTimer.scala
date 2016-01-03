package com

import com.ui.TimerExpirySubscriber
import com.ui.panel.CountdownTimerPanel

class GameTimer(val timerPanel: CountdownTimerPanel) extends Runnable {

    private val minutes: Int = 1
    private val seconds: Int = 0

    private[this] var countDownClock = CountDownClock(minute = minutes, second = seconds)

    private[this] val subscriberList = scala.collection.mutable.ListBuffer[TimerExpirySubscriber]()

    override def run(): Unit =
        do {

            Thread.sleep(1000)

            countDownClock = countDownClock.tick

            timerPanel.setTime(countDownClock.toString).updateTime

            if (countDownClock.hasExpired)
                subscriberList.foreach(_.timerHasExpired)

        } while (true)

    def addTimerExpirySubscriber(timerExpirySubscriber: TimerExpirySubscriber): Unit = {
        subscriberList += timerExpirySubscriber
    }

    def resetTimer: Unit = {
        this.synchronized {
            countDownClock = CountDownClock(minute = minutes, second = seconds)
        }
    }

}
