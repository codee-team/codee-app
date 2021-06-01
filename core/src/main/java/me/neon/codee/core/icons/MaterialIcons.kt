package me.neon.codee.core.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import me.neon.codee.core.R

class MaterialIcons : AbstractIcons {
    override val addIcon: Painter
    @Composable get() = painterResource(R.drawable.ic_round_add_24)
}