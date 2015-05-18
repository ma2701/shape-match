package com

import java.awt.Point

import com.shape.Shape
import com.util.random.RandomBoolean._
import com.util.random.{RandomBoolean, RandomNumberGenerator}


object DisplayGrid {
    val GRID_ROW_CNT = 6
    val GRID_COL_CNT = 6
}

class DisplayGrid(window: DisplayWindow, shapes: Seq[Shape], slots: Set[Int] ) {

    require(shapes.size == slots.size)
    import DisplayGrid._

    def cells = gridCells

    private val gridCells = createCells
    
    def toIndex(rowCol: (Int, Int)): Int = (GRID_ROW_CNT * rowCol._1) + rowCol._2

    def maybeAlterShapes(shouldAlterShapes: Boolean = nextRandomTrueWithOneOutOfNChance(3)): DisplayGrid=  {

        if(shouldAlterShapes) {
            val index = RandomNumberGenerator.next(0 to (shapes.size - 1))
            val toBeReplaced = shapes(index)
            val replacement  = ShapeSelector.selectOneRandomShape.moveTo(toBeReplaced.topLeft)

            val updatedShape = shapes.updated(index, replacement)
            new DisplayGrid(window, updatedShape,slots)
        } else {
            this
        }
    }

    def shapesInGrid: Int =
        cells.foldLeft(0) {
            (acc, arr) =>
                acc + arr.count( _.shape.isDefined)
        }

    def isEqual(other:DisplayGrid): Boolean = this.cells == other.cells
    def isNotEqual(other:DisplayGrid): Boolean = !isEqual(other)

    private def createCells: Seq[Seq[Cell]] = generateGridOfEmptyCells(shapes.zip(slots))

    private def generateGridOfEmptyCells(shapeIndexTuples:Seq[(Shape,Int)]): Seq[Seq[Cell]] = {
        val rows = (window.dimension.width / GRID_ROW_CNT)
        val cols = (window.dimension.height / GRID_COL_CNT)

        Seq.tabulate(GRID_ROW_CNT, GRID_COL_CNT) { (r, c) =>
            shapeIndexTuples
            .find{
                (tuple) => tuple._2 == toIndex((r, c))
            }.map {
                shapeWithPosTuple => new Cell( new Point(r * rows, c * cols), Some(shapeWithPosTuple._1))
            }.getOrElse(new Cell( new Point(r * rows, c * cols) ))
        }
    }

    override def toString: String =
        gridCells.collect { case row =>
            row.collect { case col => col.toString() + " " }
        }.mkString("\n,")

}

case class Cell(topLeft: Point, shape: Option[Shape]= None) {
    def withShape(shape: Shape): Cell = Cell(topLeft, Some(shape.moveTo(topLeft)))

    override def toString: String =
        s"x: ${topLeft.x} y: ${topLeft.y}. Shape: " + ( if(shape !=null ) s"${shape}" else " - ")
}