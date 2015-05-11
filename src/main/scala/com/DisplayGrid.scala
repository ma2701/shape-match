package com

import java.awt.Dimension

import com.util.random.RandomNumberGenerator


object DisplayGrid {
    val GRID_ROW_CNT = 6
    val GRID_COL_CNT = 6
}

class DisplayGrid(window: DisplayWindow, shapes: Seq[Shape]) {

    import DisplayGrid._

    private val gridCells = createCells

    def cells = gridCells

    def toRowCol(i: Int): Tuple2[Int, Int] =
        if(i < GRID_COL_CNT * GRID_COL_CNT )
            (i / GRID_ROW_CNT, i % GRID_COL_CNT)
        else throw new RuntimeException(s"Invalid index ${i}")

    private def createCells: Seq[Seq[Cell]] = {
        val gridCells = generateGridOfEmptyCells

        val slots = getSlotIndicesToPutShapesIn

        shapes.zip(slots).foreach { shapeAndIndexTuple =>
            val gridPos = toRowCol(shapeAndIndexTuple._2)
            gridCells(gridPos._1)(gridPos._2).setShape(shapeAndIndexTuple._1)
        }

        gridCells
    }

    private def cellCreator(dimension: Dimension): Cell = new Cell(dimension)

    private def generateGridOfEmptyCells: Seq[Seq[Cell]] = {
        val rows = (window.dimension.width / GRID_ROW_CNT)
        val cols = (window.dimension.height / GRID_COL_CNT)

        Seq.fill(GRID_ROW_CNT, GRID_COL_CNT) {
            cellCreator(new Dimension(rows, cols))
        }
    }

    private def getSlotIndicesToPutShapesIn: Set[Int] = {
        RandomNumberGenerator.nextNDistinct(shapes.size, 0 to ((GRID_COL_CNT * GRID_ROW_CNT) - 1))
    }

    class Cell(val dimension: Dimension) {
        private[this] var shape: Option[Shape] = None

        def setShape(shape: Shape): Unit = this.shape = Some(shape)
        def getShape: Option[Shape]      = this.shape

        override def toString: String =
            s"width: ${dimension.width} height: ${dimension.height}. Shape: " + ( if(shape !=null ) s"${shape}" else " - ")
    }

    override def toString: String =
        gridCells.collect { case row =>
            row.collect { case col => col.toString() + " " }
        }.mkString("\n,")


}
