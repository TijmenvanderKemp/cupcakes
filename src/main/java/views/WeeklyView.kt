package views

import dateaxis.DateAxis
import javafx.scene.chart.NumberAxis
import tornadofx.*
import java.util.*

class WeeklyView : View() {
    override val root = linechart("Weekly Sales Q2 2016", DateAxis(), NumberAxis()) {
        series("Product X") {
            data(GregorianCalendar(2019, Calendar.FEBRUARY, 7).timeInMillis, 200)
        }
    }
}