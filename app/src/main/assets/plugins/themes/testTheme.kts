@file:DependsOn(":core")

import androidx.compose.ui.graphics.Color
import me.neon.codee.core.theme.LightTheme
import me.neon.codee.core.theme.registerTheme
import kotlin.script.experimental.dependencies.DependsOn

// test theme
object BlueTheme : LightTheme("Blue") {
    override val primary: Color = Color.Blue
    override val primaryVariant: Color = Color(0, 0, 139)
    override val onPrimary: Color = Color.White
}

registerTheme(BlueTheme)