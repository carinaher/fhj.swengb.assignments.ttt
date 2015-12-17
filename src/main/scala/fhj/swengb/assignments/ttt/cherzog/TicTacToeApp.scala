package fhj.swengb.assignments.ttt.cherzog

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.fxml.{FXML, Initializable, FXMLLoader}
import javafx.scene.control.{Label, Button}
import javafx.scene.image.Image
import javafx.scene.layout.GridPane
import javafx.scene.{Parent, Scene}
import javafx.stage.Stage

import scala.util.control.NonFatal

/**
  * Implement here your TicTacToe JavaFX App.
  */


object TicTacToeApp {
  def main(args: Array[String]) {
    Application.launch(classOf[TicTacToeApp], args: _*)

  }
}

class TicTacToeApp extends javafx.application.Application {

  val Fxml = "/fhj/swengb/assignments/ttt/TicTacToeApp.fxml"

  val loader = new FXMLLoader(getClass.getResource(Fxml))

  override def start(stage: Stage): Unit =
    try {
      stage.setTitle("TicTacToe")
      loader.load[Parent]()
      stage.setScene(new Scene(loader.getRoot[Parent]))
      stage.show()
    } catch {
      case NonFatal(e) => e.printStackTrace()
    }
}

class TicTacToeAppController extends Initializable {
    @FXML var topLeft: Button = _
    @FXML var topCenter: Button = _
    @FXML var topRight: Button = _
    @FXML var middleLeft: Button = _
    @FXML var middleCenter: Button = _
    @FXML var middleRight: Button = _
    @FXML var bottomLeft: Button = _
    @FXML var bottomCenter: Button = _
    @FXML var bottomRight: Button = _
    @FXML var gridPane: GridPane = _
    @FXML var activePlayer: Label = _
    @FXML var playerWon: Label = _


    override def initialize(location: URL, resources: ResourceBundle): Unit = {
      activePlayer.setText("PlayerA")
    }

  def reset(): Unit = {
    game = TicTacToe()
    gridPane.setDisable(false)
    playerWon.setText("")


    topLeft.setText("")
    topCenter.setText("")
    topRight.setText("")
    middleLeft.setText("")
    middleCenter.setText("")
    middleRight.setText("")
    bottomLeft.setText("")
    bottomCenter.setText("")
    bottomRight.setText("")

  }

  var game = TicTacToe()
  var newgame = game

  def playMoves(move: TMove, lastgame:TicTacToe = game, buttonClicked: Button):TicTacToe = {

    if(buttonClicked.getText == "") {
      if(lastgame.nextPlayer.equals(PlayerA)) {
        buttonClicked.setText("X")
      }
      else {
        buttonClicked.setText("O")
      }

      activePlayer.setText(lastgame.nextPlayer.toString)

      newgame = lastgame.turn(move, lastgame.nextPlayer)
      println(newgame.asString())

      if(newgame.gameOver) {
        gridPane.setDisable(true)

        if(newgame.winner.isDefined) {
          playerWon.setText(lastgame.nextPlayer.toString + " " + "won!")
        }
        else
          playerWon.setText("It's a draw!")
      }
      else if(game.moveHistory.size == 9)
        gridPane.setDisable(true)
    }
    newgame
  }


  def playTL(): Unit = {
    val newgame = playMoves(TopLeft,game, topLeft); game = newgame
}

  def playTC(): Unit = {
    val newgame = playMoves(TopCenter,game, topCenter); game = newgame
  }

  def playTR(): Unit = {
    val newgame = playMoves(TopRight,game, topRight); game = newgame
  }

  def playML(): Unit = {
    val newgame = playMoves(MiddleLeft,game, middleLeft); game = newgame
  }

  def playMC(): Unit = {
    val newgame = playMoves(MiddleCenter,game, middleCenter); game = newgame
  }

  def playMR(): Unit = {
    val newgame = playMoves(MiddleRight,game, middleRight); game = newgame
  }

  def playBL(): Unit = {
    val newgame = playMoves(BottomLeft,game, bottomLeft); game = newgame
  }

  def playBC(): Unit = {
    val newgame = playMoves(BottomCenter,game, bottomCenter); game = newgame
  }

  def playBR(): Unit = {
    val newgame = playMoves(BottomRight,game, bottomRight); game = newgame
  }

}
