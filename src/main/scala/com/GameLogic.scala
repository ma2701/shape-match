package com

object GameLogic {
    val REQUIRED_CORRECT_CONSECUTIVE_ANSWERES: Int = 2
}
case class GameLogic(   currentLevel: GameLevel = GameLevel(1),
                        shapesPair  : DisplayShapesPair,
                        displayWindow : DisplayWindow,
                        correctAnswers:Int = 0,
                        score:Score       = Score()) {
    import GameLogic._

    def evaluateUserInput(userInput: UserInput): GameLogic =
        userInput match {
            case Match =>
                gameLogicBasedOnUserSelection(shapesPair.leftGrid.isEqual(shapesPair.rightGrid))
            case Mismatch =>
                gameLogicBasedOnUserSelection(shapesPair.leftGrid.isNotEqual(shapesPair.rightGrid))
        }

    def start:Unit = Unit

    def isGameOver: Boolean = false

    def isMatchingPairShapes = shapesPair.leftGrid.isEqual(shapesPair.rightGrid)

    private def gameLogicBasedOnUserSelection(shapesEquality:Boolean): GameLogic =
        if(shapesEquality)  {
            val level   = determineGameLevel
            val corrAnswers = determineCorrectAnswerCount(level)
            new GameLogic(level,
                DisplayShapes.getShapes(level, displayWindow),
                displayWindow,
                corrAnswers,
                score.add(level.points))
        } else {
            new GameLogic(
                currentLevel,
                DisplayShapes.getShapes(currentLevel, displayWindow),
                displayWindow,
                correctAnswers,
                score.deduct(currentLevel.points))
        }

    private def determineCorrectAnswerCount(level: GameLevel): Int =
        if (level == currentLevel)
            correctAnswers + 1
        else 0


    private def determineGameLevel: GameLevel =
        if (correctAnswers == (REQUIRED_CORRECT_CONSECUTIVE_ANSWERES - 1))
            currentLevel.nextLevel
        else
            currentLevel

}
