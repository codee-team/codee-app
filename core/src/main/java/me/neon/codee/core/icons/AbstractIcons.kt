package me.neon.codee.core.icons

interface AbstractIcons {
    val addIcon: Icon
}

sealed interface Icon

class IconFile(name: String) : Icon
class ResourceIcon(resourceId: Int) : Icon