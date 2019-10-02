package views

import dateaxis.DateAxis
import javafx.scene.chart.NumberAxis
import repos.SaleRepo
import tornadofx.*
import java.time.ZoneId

class DailyView : View() {
    private val saleRepo: SaleRepo by di()

    override val root = linechart("$$$ per day", DateAxis(), NumberAxis()) {
        series("Cupcakes") {
            for ((income, date) in saleRepo.findAll()) {
                data(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), income)
            }
        }
    }
}