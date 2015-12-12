package fhj.swengb.assignments.ttt.cherzog

import java.net.URL
import java.util.ResourceBundle
import javafx.application.Application
import javafx.fxml.{FXML, Initializable, FXMLLoader}
import javafx.scene.control.{Label, Button}
import javafx.scene.image.Image
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


    override def initialize(location: URL, resources: ResourceBundle): Unit = {

    }


  def reset(): Unit = {
    topLeft.setText(" ")
    topCenter.setText(" ")
    topRight.setText(" ")
    middleLeft.setText(" ")
    middleCenter.setText(" ")
    middleRight.setText(" ")
    bottomLeft.setText(" ")
    bottomCenter.setText(" ")
    bottomRight.setText(" ")

  }

  def click0(): Unit = topLeft.setText("X")
  def click1(): Unit = topCenter.setText("X")
  def click2(): Unit = topRight.setText("X")
  def click3(): Unit = middleLeft.setText("X")
  def click4(): Unit = middleCenter.setText("X")
  def click5(): Unit = middleRight.setText("X")
  def click6(): Unit = bottomLeft.setText("X")
  def click7(): Unit = bottomCenter.setText("X")
  def click8(): Unit = bottomRight.setText("X")

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
