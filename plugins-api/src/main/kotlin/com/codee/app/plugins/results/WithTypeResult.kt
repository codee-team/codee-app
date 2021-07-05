package com.codee.app.plugins.results

public sealed interface WithTypeError {
    /**
     * Appears if version exceeded max version specified in request.
     * @param typeVersion - version of registered api.
     */
    public class MaxVersionExceed(public val typeVersion: Int) : WithTypeError

    /**
     * Appears if version undervalued min version specified in request.
     * @param typeVersion - version of registered api.
     */
    public class MinVersionExceed(public val typeVersion: Int) : WithTypeError

    /**
     * Appears when specified type not found.
     */
    public object NotFound : WithTypeError
}