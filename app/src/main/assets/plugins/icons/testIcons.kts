@file:DependsOn(":core")
@file:DependsOn(":app")

import me.neon.codee.core.icons.AbstractIcons
import me.neon.codee.core.icons.Icon
import me.neon.codee.core.icons.IconFile
import kotlin.script.experimental.dependencies.DependsOn

object TestIcons : AbstractIcons {
    override val addIcon: Icon = IconFile("add_icon_name.png")
}