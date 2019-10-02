package views

import controllers.FileController
import javafx.beans.property.SimpleStringProperty
import javafx.stage.FileChooser
import repos.SaleRepo
import tornadofx.*

class MainView : View() {
    private val controller: FileController by inject()
    private val saleRepo: SaleRepo by di()


    val prop = SimpleStringProperty()

    override val root = vbox {
        button("Upload sales") {
            action {
                val files = chooseFile(filters = arrayOf(FileChooser.ExtensionFilter("Text files only", listOf("*.txt"))))
                controller.uploadFiles(files)
            }
        }
        button("Show latest sale") {
            action {
                prop.set(saleRepo.latest().toString())
            }
        }
        text(prop)
    }
}