package com

import java.awt.Dimension


object DisplayGrid{
    val GRID_ROW_CNT= 6
    val GRID_COL_CNT= 6
}
class DisplayGrid(window: DisplayWindow) {
    private val gridCells = createCells

    def cells = gridCells

    override def toString: String =
        gridCells.collect { case row =>
            row.collect { case col => col.toString() + " " }
        }.mkString("\n,")

    private def createCells: Seq[Seq[Cell]] = {
        import DisplayGrid._
        val rows = (window.dimension.width / GRID_ROW_CNT)
        val cols = (window.dimension.height / GRID_COL_CNT)

        Seq.fill(GRID_ROW_CNT, GRID_COL_CNT) {
            cellCreator(new Dimension(rows, cols))
        }
    }

    private def cellCreator(dimension: Dimension): Cell = new Cell(dimension)

    class Cell(val dimension: Dimension) {
        override def toString: String = s"width: ${dimension.width} height: ${dimension.height} "
    }


}
