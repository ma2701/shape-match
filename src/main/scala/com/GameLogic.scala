package com

class GameLogic(val currentLevel: GameLevel = LevelOne,
                val shapesPair  : DisplayShapesPair,
                val displayWindow : DisplayWindow ) {

    def isUserInputCorrect(userInput: UserInput): GameLogic =
        userInput match {
            case Match =>
                gameLogicBasedOnUserSelection(shapesPair.leftGrid.isEqual(shapesPair.rightGrid))
            case Mismatch =>
                gameLogicBasedOnUserSelection(shapesPair.leftGrid.isNotEqual(shapesPair.rightGrid))
        }

    def start:Unit = Unit

    def isGameOver: Boolean = currentLevel.isLastLevel

    private def gameLogicBasedOnUserSelection(shapesPairEquality:Boolean): GameLogic =
        if(shapesPairEquality)  {
            val nextLevel  = currentLevel.nextLevel
            new GameLogic(nextLevel, DisplayShapes.getShapes(nextLevel, displayWindow), displayWindow)
        } else {
            new GameLogic(currentLevel, DisplayShapes.getShapes(currentLevel, displayWindow), displayWindow)
        }
}
