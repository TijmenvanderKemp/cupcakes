import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.scene.chart.XYChart
import tornadofx.*

class ObservableDataPointList<Y>(private val map: ObservableMap<out Any, out Y>,
                                 private val list: List<XYChart.Data<String, Y>> = map.map { (x, y) -> XYChart.Data(x.toString(), y) })
    : ObservableList<XYChart.Data<String, Y>> by list.asObservable()