import com.google.inject.Inject
import com.google.inject.Singleton
import repos.SaleRepo

@Singleton
class EarningsModelImpl @Inject constructor(private val saleRepo: SaleRepo) : EarningsModel {

    override val refreshableMapDaily = RefreshableMap { saleRepo.findAllPerDay() }
    override val refreshableMapWeekly = RefreshableMap { saleRepo.findAllPerWeek() }
    override val refreshableMapMonthly = RefreshableMap { saleRepo.findAllPerMonth() }
    override val refreshableMapYearly = RefreshableMap { saleRepo.findAllPerYear() }

    override fun refreshAll() {
        refreshableMapDaily.refresh()
        refreshableMapWeekly.refresh()
        refreshableMapMonthly.refresh()
        refreshableMapYearly.refresh()
    }
}

