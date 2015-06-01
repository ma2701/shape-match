package com.ui

import com.ui.panel._


object LayeredPaneElements {

    def default: LayeredPaneElements =
        LayeredPaneElements (
            rightShapePanel = new RightShapePanel,
            leftShapePanel = new LeftShapePanel,
            gameStartPanel = new GameStartPanel,
            finalScorePanel = new FinalScorePanel)
}

case class LayeredPaneElements(rightShapePanel: RightShapePanel,
                               leftShapePanel: LeftShapePanel,
                               gameStartPanel: GameStartPanel,
                               finalScorePanel: FinalScorePanel)