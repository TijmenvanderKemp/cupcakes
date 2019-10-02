package views

import controllers.FileController
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.stage.FileChooser
import repos.SaleRepo
import tornadofx.*

class MainView : View() {
    private val controller: FileController by inject()
    private val dailyView: DailyView by inject()
    private val weeklyView: WeeklyView by inject()
    private val saleRepo: SaleRepo by di()

    private var graph: View = dailyView

    private val prop = SimpleStringProperty()
    private val showGraph = SimpleBooleanProperty()

    override val root = vbox {
        hbox {
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
            button("Show daily") {
                action { graph.replaceWith<DailyView>() }
            }
            button("Show weekly") {
                action { graph.replaceWith<WeeklyView>() }
            }
        }
        this.add(graph)
    }
}