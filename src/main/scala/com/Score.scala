package com


case class Score(points: Int = 0) {

    def add(pts: Int): Score = Score(points + pts)

    def deduct(pts: Int): Score = Score(points - pts)
}

