package fhj.swengb.assignments.ttt.cherzog

/**
  * Implement here your TicTacToe JavaFX App.
  */


object TicTacToeApp {

  def main(args: Array[String]) {
    val seperator = "|---|---|---|\n"
    val board = List(TopLeft.idx,TopCenter.idx,TopRight.idx,
                MiddleLeft.idx,MiddleCenter.idx,MiddleRight.idx,
                BottomLeft.idx,BottomCenter.idx,BottomRight.idx)

    print(seperator +
      "|-"+board(0)+"-|-"+board(1)+"-|-"+board(2)+"-|\n"+
      seperator +
      "|-"+board(3)+"-|-"+board(4)+"-|-"+board(5)+"-|\n"+
      seperator +
      "|-"+board(6)+"-|-"+board(7)+"-|-"+board(8)+"-|\n"+
      seperator)


  }

}