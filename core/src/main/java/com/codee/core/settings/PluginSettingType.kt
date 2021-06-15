package com.codee.core.settings


sealed class PluginSettingType<TSettingType> {
    // Used to note some meta info such as plugin version or developers
    object PlainText : PluginSettingType<String>()

    sealed class Inline<TSettingType> : PluginSettingType<TSettingType>() {
        object Switch : Inline<Boolean>()
    }

    sealed class Picker<TSettingType> : PluginSettingType<TSettingType>() {
        object String : Picker<kotlin.String>()
        object Int : Picker<kotlin.Int>()
        object SimpleInt : Picker<kotlin.Int>()
        object RGBColor : Picker<UInt>()
        object RGBAColor : Picker<UInt>()
    }
}
