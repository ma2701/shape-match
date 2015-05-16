package com

import com.ui.ShapeMatchFrame

object Main extends App {

    override def main(args: Array[String]) :Unit =  {

        val frame = new ShapeMatchFrame

        java.awt.EventQueue.invokeLater(new Runnable {
            def run {
                frame.setVisible(true)
            }
        })

        println("after teh frame creation....")
    }
}
