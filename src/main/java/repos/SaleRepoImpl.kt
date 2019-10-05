package repos

import com.google.inject.Singleton
import entities.EarningPerDay
import entities.Month
import entities.Week
import java.time.LocalDate

@Singleton
class SaleRepoImpl : SaleRepo {
    private var earningsPerDay: List<EarningPerDay> = emptyList()

    override fun persist(earnings: List<Int>) {
        val startDate = LocalDate.now()
        val backwardsDates: Sequence<LocalDate> = generateSequence(startDate) { date -> date.minusDays(1) }
        earningsPerDay = backwardsDates.zip(earnings.asSequence())
                .map { EarningPerDay(it.first, it.second) }
                .toList().reversed()
        println("$earnings persisted")
    }

    override fun findAllPerDay() = earningsPerDay.toMap()

    private fun List<EarningPerDay>.toMap() = this.map { it.day to it.earnings }.toMap()

    override fun findAllPerWeek(): Map<Week, Int> {
        val perYear: Map<Int, List<EarningPerDay>> = earningsPerDay.groupBy { it.day.year }
        val perWeek: MutableMap<Week, Int> = mutableMapOf()
        perYear.forEach { year ->
            val weeklyEarnings = splitYearIntoWeeklyEarnings(year)
            weeklyEarnings
                    .forEach { (week, earning) -> perWeek[week] = earning }
        }
        return perWeek
    }

    private fun splitYearIntoWeeklyEarnings(year: Map.Entry<Int, List<EarningPerDay>>): List<Pair<Week, Int>> {
        val listOfSevenDays: List<List<EarningPerDay>> = year.value.chunked(7)
        val withWeekNumber: Iterable<IndexedValue<List<EarningPerDay>>> = listOfSevenDays.withIndex()
        return withWeekNumber.map { Week(it.index, it.value[0].day.year) to it.value.sumBy { earningPerDay -> earningPerDay.earnings } }
    }

    override fun findAllPerMonth(): Map<Month, Int> {
        return earningsPerDay.groupBy { Month(it.day.month, it.day.year) }.sum()
    }

    override fun findAllPerYear(): Map<Int, Int> {
        return earningsPerDay.groupBy { it.day.year }.sum()
    }

    private fun <T> Map<T, List<EarningPerDay>>.sum(): Map<T, Int> =
            this.mapValues { earningPerDay -> earningPerDay.value.sumBy { it.earnings } }
}