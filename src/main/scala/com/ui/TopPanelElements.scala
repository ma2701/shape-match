package com.ui

import com.ui.panel.{CountdownTimerPanel, GameStatusPanel, TopPanel}

object TopPanelElements {

    def default(shapeMatchFrame: TopPanel):TopPanelElements =
        TopPanelElements(
            new CountdownTimerPanel,
            new GameStatusPanel)
}

case class TopPanelElements(countdownTimerPanel: CountdownTimerPanel, statusPanel: GameStatusPanel)
