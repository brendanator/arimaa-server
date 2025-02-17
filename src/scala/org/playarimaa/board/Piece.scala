package org.playarimaa.board
import org.playarimaa.util._

case class Piece(owner: Player, pieceType: PieceType) {
  def toChar: Char =
    this.owner match {
      case GOLD => this.pieceType.lowercaseChar.toUpper
      case SILV => this.pieceType.lowercaseChar
    }
}

object Piece {

  val values: List[Piece] =
    Player.values.flatMap( p =>
      PieceType.values.map( pt =>
        Piece(p,pt)
      )
    )

  def ofChar(c: Char): Result[Piece] =
    PieceType.ofChar(c).map { pt =>
      val player = if(c.isUpper) GOLD else SILV
      Piece(player,pt)
    }

  /** For testing only. */
  def main(args: Array[String]) {
    Piece.values foreach ((s: Piece) => println(s.toChar))
  }
}
