private val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')

/**
 * Generates random string from [chars].
 * @return [String] with random set of chars.
 */
internal fun randomString(length: Int): String {
    return (1..length)
        .map { chars.random() }
        .joinToString("")
}