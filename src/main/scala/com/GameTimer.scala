package com

import com.ui.{TimerExpirySubscriber, CountdownTimerPanel}

class GameTimer(val timerPanel: CountdownTimerPanel) extends Runnable {

    private[this] var minuteClock :    CountDownClock = CountDownClock(1,30)

    private[this] val subscriberList = scala.collection.mutable.ListBuffer[TimerExpirySubscriber]()

    override def run(): Unit = {
        do {

            Thread.sleep(1000)

            minuteClock = minuteClock.tick

            timerPanel.setTime(minuteClock.toString).updateTime

            notifySubscribers

        } while(true)
    }

    def notifySubscribers: Unit = {
        if (minuteClock.isOutOfTime) {
            subscriberList.foreach(_.timerHasExpired)
        }
    }

    def addTimerExpirySubscriber(timerExpirySubscriber: TimerExpirySubscriber): Unit = {
        subscriberList += timerExpirySubscriber
    }

}
