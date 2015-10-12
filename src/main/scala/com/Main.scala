package com

import com.ui.{ShapeMatchFrame, RealShapeMatchFrameFactory}

object Main extends App {

    override def main(args: Array[String]): Unit = {

        val frame  = RealShapeMatchFrameFactory.construct

        start(frame)
    }

    def start(smf: ShapeMatchFrame): Unit = {
        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                smf.setVisible(true)
            }
        })
    }
}
