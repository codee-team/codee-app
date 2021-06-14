package com.codee.plugins.api

import com.codee.plugins.api.strings.IStrings

public interface Strings {
    /**
     * Sets strings in forced way.
     * @param strings - localized strings.
     */
    public fun setStrings(strings: IStrings)

    /**
     * Sets strings for [languageCode].
     * @param languageCode - language code of localized strings.
     * @param strings - localized strings.
     */
    public fun setStrings(languageCode: String, strings: IStrings)
}