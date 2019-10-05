package repos

import entities.Month
import entities.Week
import java.time.LocalDate

interface SaleRepo {
    fun persist(earnings: List<Int>)
    fun findAllPerDay(): Map<LocalDate, Int>
    fun findAllPerWeek(): Map<Week, Int>
    fun findAllPerMonth(): Map<Month, Int>
    fun findAllPerYear(): Map<Int, Int>
}