import dev.misfitlabs.kotlinguice4.KotlinModule
import repos.SaleRepo
import repos.SaleRepoImpl

class SalesModule : KotlinModule() {
    override fun configure() {
        bind<SaleRepo>().to<SaleRepoImpl>()
    }

}
