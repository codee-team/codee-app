package com.codee.plugins.api.settings


public sealed class PluginSettingType<TSettingType> {
    // Used to note some meta info such as plugin version or developers
    public object PlainText : PluginSettingType<String>()

    public sealed class Inline<TSettingType> : PluginSettingType<TSettingType>() {
        public object Switch : Inline<Boolean>()
    }
    public sealed class Picker<TSettingType> : PluginSettingType<TSettingType>() {
        public object String : Picker<kotlin.String>()
        public object Int : Picker<kotlin.Int>()
        public object SimpleInt : Picker<kotlin.Int>()
        public object RGBColor : Picker<UInt>()
        public object RGBAColor : Picker<UInt>()
    }
}
