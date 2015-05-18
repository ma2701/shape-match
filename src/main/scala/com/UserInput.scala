package com


sealed trait UserInput

object UserInput {
    def fromString(str:String):UserInput =
        if(str.toLowerCase == "mismatch")
            Mismatch
        else if(str.toLowerCase == "match")
            Match
        else
            throw new IllegalArgumentException(s"UserInput is invalid. Given ${str}. It has to be either 'match' or 'mismatch'")
}

object Match extends UserInput

object Mismatch extends UserInput