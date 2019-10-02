import com.google.inject.Guice
import tornadofx.*
import views.MainView
import kotlin.reflect.KClass

class CupcakesApp : App(MainView::class) {
    init {
        val guice = Guice.createInjector(MyModule())

        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>) = guice.getInstance(type.java)
        }
    }
}