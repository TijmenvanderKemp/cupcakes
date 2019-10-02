package repos

import com.google.inject.Singleton
import java.time.LocalDate

@Singleton
class SaleRepoImpl : SaleRepo {
    private var earningsOverTime: List<Pair<Int, LocalDate>> = emptyList()

    override fun persist(earnings: List<Int>) {
        val startDate = LocalDate.now()
        val backwardsDates: Sequence<LocalDate> = generateSequence(startDate) { date -> date.minusDays(1) }
        earningsOverTime = earnings.asSequence().zip(backwardsDates).toList()
        println("$earnings persisted")
    }

    override fun findAll() = earningsOverTime
}