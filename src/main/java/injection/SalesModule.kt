package injection

import dev.misfitlabs.kotlinguice4.KotlinModule
import models.EarningsModel
import models.EarningsModelImpl
import repos.SaleRepo
import repos.SaleRepoImpl

class SalesModule : KotlinModule() {
    override fun configure() {
        bind<SaleRepo>().to<SaleRepoImpl>()
        bind<EarningsModel>().to<EarningsModelImpl>()
    }

}
