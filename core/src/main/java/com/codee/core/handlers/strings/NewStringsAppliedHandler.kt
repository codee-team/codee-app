package com.codee.core.handlers.strings

import com.codee.plugins.api.strings.IStrings

interface NewStringsAppliedHandler {
    /**
     * When new `Strings` applied.
     * @param strings - new strings.
     */
    fun onNewStringsApplied(strings: IStrings)
}