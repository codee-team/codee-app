package com.codee.plugins.api

import com.codee.plugins.api.localization.ApplicationLocalization

public interface Localization {
    /**
     * Sets localization.
     * @param localization - localized strings.
     */
    public fun setLocalization(localization: ApplicationLocalization)
}