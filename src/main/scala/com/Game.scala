package com

import com.ui.ShapeMatchFrame

class Game (frame: ShapeMatchFrame) {
    require(frame != null)

    def start: Unit = {
        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                frame.setVisible(true)
            }
        })
    }


}

