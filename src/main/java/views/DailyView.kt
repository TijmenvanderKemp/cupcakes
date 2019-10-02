package views

import dateaxis.DateAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*
import java.util.*

class DailyView : View() {
    override val root = linechart("Unit Sales Q2 2016", DateAxis(), NumberAxis()) {
        series("Product X") {
            data(GregorianCalendar(2019, Calendar.FEBRUARY, 1).timeInMillis, 10245)
        }
    }
}