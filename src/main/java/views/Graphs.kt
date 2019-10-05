package views

import EarningsModel
import ObservableDataPointList
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.scene.Parent
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import tornadofx.*


class DailyView : View() {
    private val earningsModel: EarningsModel by di()

    override val root = categoryChart("Daily earnings", earningsModel.refreshableMapDaily.observableMap)
}

class WeeklyView : View() {
    private val earningsModel: EarningsModel by di()

    override val root = categoryChart("Weekly earnings", earningsModel.refreshableMapWeekly.observableMap)
}

class MonthlyView : View() {
    private val earningsModel: EarningsModel by di()

    override val root = categoryChart("Monthly earnings", earningsModel.refreshableMapMonthly.observableMap)
}

class YearlyView : View() {
    private val earningsModel: EarningsModel by di()

    override val root = categoryChart("Yearly earnings", earningsModel.refreshableMapYearly.observableMap)
}

fun View.categoryChart(chartTitle: String, dataPoints: ObservableMap<out Any, out Number>): Parent {
    val elements: ObservableList<XYChart.Data<String, Number>> = ObservableDataPointList(map = dataPoints)
    return linechart(chartTitle, CategoryAxis(), NumberAxis()) {
        setPrefSize(1000.0, 800.0)
        series("Cupcakes", elements)
    }
}
