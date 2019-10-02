package views

import controllers.FileController
import javafx.stage.FileChooser
import tornadofx.*

class MainView : View() {
    private val controller: FileController by inject()
    private val dailyView: DailyView by inject()
    private val weeklyView: WeeklyView by inject()
    private val monthlyView: MonthlyView by inject()
    private val yearlyView: YearlyView by inject()

    override val root = vbox {
        hbox {
            button("Upload sales") {
                action {
                    val files = chooseFile(filters = arrayOf(FileChooser.ExtensionFilter("Text files only", listOf("*.txt"))))
                    controller.uploadFiles(files)
                }
            }
            button("Show daily") {
                action { dailyView.openModal() }
            }
            button("Show weekly") {
                action { weeklyView.openModal() }
            }
            button("Show monthly") {
                action { monthlyView.openModal() }
            }
            button("Show yearly") {
                action { yearlyView.openModal() }
            }
        }
    }
}