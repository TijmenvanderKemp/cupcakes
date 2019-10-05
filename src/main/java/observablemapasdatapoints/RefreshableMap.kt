package observablemapasdatapoints

import tornadofx.*

class RefreshableMap<K, V>(private val supplier: () -> Map<K, V>) {
    fun refresh() {
        observableMap.clear()
        observableMap.putAll(supplier.invoke())
    }

    val observableMap = supplier.invoke().toMutableMap().asObservable()

}