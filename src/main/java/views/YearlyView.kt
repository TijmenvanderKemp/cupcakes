package views

import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import repos.SaleRepo
import tornadofx.*
import java.time.LocalDate

class YearlyView : View() {
    private val saleRepo: SaleRepo by di()

    override val root = linechart("$$$ per year", CategoryAxis(), NumberAxis()) {
        series("Cupcakes") {
            val findAll = saleRepo.findAll()
            val byYear: Map<Int, List<Pair<Int, LocalDate>>> = findAll.groupBy { it.second.year }
            val totalPerYear: Map<Int, Int> = byYear.mapValues { it.value.sumBy { pair -> pair.first } }
            for ((year, dollars) in totalPerYear) {
                data(year.toString(), dollars)
            }
        }
    }
}