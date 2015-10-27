package com.ui

import java.awt.event.ActionListener
import java.awt.{Frame, Color, Font}
import javax.swing.JButton

class Button(bgColor: Color, fgColor: Color, font: Font, text: String) extends JButton {

    setBackground(bgColor)
    setFont(font) // NOI18N
    setForeground(fgColor)
    setText(text)

    def actionListener(actionListener: ActionListener): Unit = {
        addActionListener(actionListener)
    }

}
