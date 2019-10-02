package repos

import com.google.inject.Singleton

@Singleton
class SaleRepoImpl : SaleRepo {
    private val earningsOverTime = mutableListOf<Int>()

    override fun persist(earnings: Int) {
        earningsOverTime.add(earnings)
        println("$earnings persisted")
    }

    override fun latest() = earningsOverTime.last()
}