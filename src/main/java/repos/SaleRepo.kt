package repos

class SaleRepo {
    private val list = mutableListOf<Int>()
    fun persist(int: Int) {
        list.add(int)
    }
}