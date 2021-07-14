@file:Suppress("MemberVisibilityCanBePrivate")

package com.codee.app.plugins.results

import com.codee.app.resources.locale.strings.LocalizedString

public sealed interface ValidateResult {
    /**
     * Marks that validation succeed and there no problem.
     */
    public object Success : ValidateResult

    /**
     * Marks that validation returned warning (not critical, but need to be reviewed).
     * @param message - warning message.
     */
    public class Warning(public val message: LocalizedString) : ValidateResult

    /**
     * Marks that validation returned error (critical, should be fixed).
     * @param message - warning message.
     */
    public class Error(public val message: LocalizedString) : ValidateResult
}