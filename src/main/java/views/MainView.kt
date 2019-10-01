package views

import controllers.FileController
import javafx.stage.FileChooser
import tornadofx.*

class MainView : View() {
    private val controller: FileController by inject()

    override val root = vbox {
        button("Upload sales") {
            action {
                val files = chooseFile(filters = arrayOf(FileChooser.ExtensionFilter("Text files only", listOf("*.txt"))))
                controller.uploadFiles(files)
            }
        }
    }
}