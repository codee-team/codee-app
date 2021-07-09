package com.codee.app.plugins.results

public class Either<TSuccess, TError> private constructor(
    public val value: TSuccess?,
    public val error: TError?
) {
    public val isSuccess: Boolean get() = value != null

    public companion object {
        public fun <T> success(value: T): Either<T, Nothing> =
            Either(value, null)

        public fun <T> error(error: T): Either<Nothing, T> =
            Either(null, error)
    }
}

/**
 * Returns [T] instance or [NullPointerException].
 */
@Throws(NullPointerException::class)
public fun <T, E> Either<T, E>.valueOrThrow(): T = value
    ?: throw NullPointerException("value is null.")

@Throws(NullPointerException::class)
public fun <T, E> Either<T, E>.errorOrThrow(): E = error
    ?: throw NullPointerException("error is null")

public fun <T, E> Either<T, E>.onSuccess(block: (T) -> Unit): Either<T, E> = apply {
    if (isSuccess)
        block(valueOrThrow())
}

public fun <T, E> Either<T, E>.onError(block: (E) -> Unit): Either<T, E> = apply {
    if (!isSuccess)
        block(errorOrThrow())
}