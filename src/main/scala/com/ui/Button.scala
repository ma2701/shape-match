package com.ui

import java.awt.{Color, Font}
import javax.swing.JButton

class Button(frame:ShapeMatchFrame, bgColor: Color, font: Font, fgColor:Color, text:String) extends JButton {

    setBackground(bgColor)
    setFont(font) // NOI18N
    setForeground(fgColor)
    setText(text)

    addActionListener(frame)
}
