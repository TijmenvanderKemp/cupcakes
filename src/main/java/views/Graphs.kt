package views

import javafx.scene.Parent
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import repos.SaleRepo
import tornadofx.*


class DailyView : View() {
    private val saleRepo: SaleRepo by di()

    override val root = categoryChart("Daily earnings", saleRepo.findAllPerDay())
}

class WeeklyView : View() {
    private val saleRepo: SaleRepo by di()

    override val root = categoryChart("Weekly earnings", saleRepo.findAllPerWeek())
}

class MonthlyView : View() {
    private val saleRepo: SaleRepo by di()

    override val root = categoryChart("Montly earnings", saleRepo.findAllPerMonth())
}

class YearlyView : View() {
    private val saleRepo: SaleRepo by di()

    override val root = categoryChart("Yearly earnings", saleRepo.findAllPerYear())
}

fun View.categoryChart(chartTitle: String, dataPoints: Map<out Any, Int>): Parent {
    return linechart(chartTitle, CategoryAxis(), NumberAxis()) {
        setPrefSize(1000.0, 800.0)
        series("Cupcakes") {
            for ((xAxisPoint, dollars) in dataPoints) {
                data(xAxisPoint.toString(), dollars)
            }
        }
    }
}

