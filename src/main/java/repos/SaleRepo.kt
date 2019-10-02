package repos

interface SaleRepo {
    fun persist(earnings: Int)
    fun latest(): Int
}