package com

import com.ui.TimerExpirySubscriber
import com.ui.panel.CountdownTimerPanel

class GameTimer(val timerPanel: CountdownTimerPanel) extends Runnable {

    private[this] var countDownClock = CountDownClock(1, 30)

    private[this] val subscriberList = scala.collection.mutable.ListBuffer[TimerExpirySubscriber]()

    override def run(): Unit = {
        do {

            Thread.sleep(1000)

            countDownClock = countDownClock.tick

            timerPanel.setTime(countDownClock.toString).updateTime

            if (countDownClock.isOutOfTime)
                subscriberList.foreach(_.timerHasExpired)

        } while (true)
    }

    def addTimerExpirySubscriber(timerExpirySubscriber: TimerExpirySubscriber): Unit = {
        subscriberList += timerExpirySubscriber
    }

}
