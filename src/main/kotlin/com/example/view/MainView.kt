package com.example.view

import javafx.beans.property.SimpleIntegerProperty
import javafx.scene.control.Alert
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.View


class MainView : View("Hello TornadoFX") {
    override val root : BorderPane by fxml("/views/CounterView.fxml")
    val counter = SimpleIntegerProperty()
    val counterLabel: Label by fxid("counterLabel")

    fun increment(){
        counterLabel.text = "hello fuckers"
        Alert(Alert.AlertType.INFORMATION, "Sample").show()
    }
}
