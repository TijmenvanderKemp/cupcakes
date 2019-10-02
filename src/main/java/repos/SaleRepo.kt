package repos

import java.time.LocalDate

interface SaleRepo {
    fun persist(earnings: List<Int>)
    fun findAll(): List<Pair<Int, LocalDate>>
}