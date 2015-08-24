package com

import com.ui.TimerExpirySubscriber
import com.ui.panel.CountdownTimerPanel

class GameTimer(val timerPanel: CountdownTimerPanel) extends Runnable {

    private[this] var countDownClock = CountDownClock(minute=1, second = 30)

    private[this] val subscriberList = scala.collection.mutable.ListBuffer[TimerExpirySubscriber]()

    override def run(): Unit = {
        do {

            Thread.sleep(1000)

            countDownClock = countDownClock.tick

            timerPanel.setTime(countDownClock.toString).updateTime

            if (countDownClock.hasExpired)
                subscriberList.foreach(_.timerHasExpired)

        } while (!countDownClock.hasExpired)
    }

    def addTimerExpirySubscriber(timerExpirySubscriber: TimerExpirySubscriber): Unit = {
        subscriberList += timerExpirySubscriber
    }

}
