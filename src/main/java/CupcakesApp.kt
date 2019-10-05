import com.google.inject.Guice
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import tornadofx.*
import views.MainView
import kotlin.reflect.KClass

class CupcakesApp : App(MainView::class) {
    init {
        val guice = Guice.createInjector(SalesModule())

        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>) = guice.getInstance(type.java)
        }

        FX.layoutDebuggerShortcut = KeyCodeCombination(KeyCode.D)
    }
}