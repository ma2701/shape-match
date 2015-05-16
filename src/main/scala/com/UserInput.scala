package com

sealed trait UserInput

object Match extends UserInput
object NoMatch extends UserInput