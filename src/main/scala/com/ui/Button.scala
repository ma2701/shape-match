package com.ui

import java.awt.{Color, Font}
import javax.swing.JButton

class Button(frame: ShapeMatchFrame, bgColor: Color, fgColor: Color, font: Font, text: String) extends JButton {

    setBackground(bgColor)
    setFont(font) // NOI18N
    setForeground(fgColor)
    setText(text)

    addActionListener(frame)
}
