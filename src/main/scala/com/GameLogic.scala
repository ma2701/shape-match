package com

class GameLogic(displayShapes: DisplayShapes = new DisplayShapes){
    private val emptyShapesMap = Map.empty[String, Seq[Shape]]


    def start:Unit = Unit

    def getDisplayShapes(gameLevel: GameLevel): Map[String,Seq[Shape]] =
        displayShapes.getShapes(gameLevel)

    def isUserInputCorrect(userInput: UserInput, presentedShapes: Map[String, Seq[Shape]]):Boolean =
        userInput match {
            case Match =>
                presentedShapes.get("left").getOrElse(emptyShapesMap) == presentedShapes.get("right").getOrElse(emptyShapesMap)
            case NoMatch =>
                presentedShapes.get("left").getOrElse(emptyShapesMap) != presentedShapes.get("right").getOrElse(emptyShapesMap)

        }


}
