package com

object GameLogic {
    val REQUIRED_CORRECT_CONSECUTIVE_ANSWERES: Int = 3
}
case class GameLogic(   currentLevel: GameLevel = LevelOne,
                        shapesPair  : DisplayShapesPair,
                        displayWindow : DisplayWindow,
                        correctAnswers:Int = 0 ) {
    import GameLogic._

    def evaluateUserInput(userInput: UserInput): GameLogic =
        userInput match {
            case Match =>
                gameLogicBasedOnUserSelection(shapesPair.leftGrid.isEqual(shapesPair.rightGrid))
            case Mismatch =>
                gameLogicBasedOnUserSelection(shapesPair.leftGrid.isNotEqual(shapesPair.rightGrid))
        }

    def start:Unit = Unit

    def isGameOver: Boolean = currentLevel.isLastLevel

    def isMatchingPairShapes = shapesPair.leftGrid.isEqual(shapesPair.rightGrid)

    private def gameLogicBasedOnUserSelection(shapesPairEquality:Boolean): GameLogic =
        if(shapesPairEquality)  {
            val nextLevel  = if(correctAnswers == (REQUIRED_CORRECT_CONSECUTIVE_ANSWERES -1 ) ) currentLevel.nextLevel else currentLevel
            val corrAnswers = if(nextLevel == currentLevel)  correctAnswers +1 else 0
            new GameLogic(nextLevel, DisplayShapes.getShapes(nextLevel, displayWindow), displayWindow, corrAnswers )
        } else {
            new GameLogic(currentLevel, DisplayShapes.getShapes(currentLevel, displayWindow), displayWindow, correctAnswers)
        }
}
