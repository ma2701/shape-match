package com.ui

object TimerUIElements {

    def default(shapeMatchFrame: TopPanel):TimerUIElements =
        TimerUIElements(
            new CountdownTimerPanel,
            new GameStatusPanel)
}

case class TimerUIElements(countdownTimerPanel: CountdownTimerPanel, statusPanel: GameStatusPanel)
