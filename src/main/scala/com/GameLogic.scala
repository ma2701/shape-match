package com

class GameLogic(val currentLevel: GameLevel = LevelOne,
                val shapesPair      : DisplayShapesPair = DisplayShapesPair()) {

    def isUserInputCorrect(userInput: UserInput): GameLogic =
        userInput match {
            case Match =>
                gameLogicBasedOnUserSelection(shapesPair.left == shapesPair.right)
            case Mismatch =>
                gameLogicBasedOnUserSelection(shapesPair.left != shapesPair.right)

        }

    def start:Unit = Unit

    def isGameOver: Boolean = currentLevel.isLastLevel

    private def gameLogicBasedOnUserSelection(shapesPairEquality:Boolean): GameLogic =
        if(shapesPairEquality)  {
            val nextLevel  = currentLevel.nextLevel
            new GameLogic(nextLevel, DisplayShapes.getShapes(nextLevel))
        } else {
            new GameLogic(currentLevel, DisplayShapes.getShapes(currentLevel))
        }
}
