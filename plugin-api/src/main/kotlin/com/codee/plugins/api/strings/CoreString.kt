package com.codee.plugins.api.strings


public abstract class CoreStrings : LocalizedStrings() {
    public abstract val hello: LocalizedString
    public abstract val developer: LocalizedString
}

public object DefaultStrings : CoreStrings() {
    override val hello: LocalizedString = string(default = "Hello") {
        val ru by value("Привет")
        val ua by value("Прiвiт")
    }

    override val developer: LocalizedString = string(default = "Developer") {
        val ru by value("Разработчик")
    }
}
