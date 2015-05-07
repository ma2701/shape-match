package com

import java.awt.Graphics

abstract class UserInterface {
    def draw:Unit
}

class SwingUserInterface(graphics: Graphics) extends UserInterface {
    override def draw: Unit = ???
}
