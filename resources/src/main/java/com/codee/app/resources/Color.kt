package com.codee.app.resources

/**
 * The base class of any color.
 */
public sealed interface Color {
    public companion object {
        public val WHITE: Color = Hex("#ffffff")
        public val BLACK: Color = Hex("#000000")
        public val RED: Color = Hex("#F44336")
    }
}

/**
 * Color in RGB format.
 * @param red - alpha value of red color.
 * @param green - alpha value of green color.
 * @param blue - alpha value of blue color.
 */
public class RGB(
    public val red: Int,
    public val green: Int,
    public val blue: Int
) : Color

/**
 * Color in HEX format.
 * @param hex - color in hex format (e.x: #ffffff).
 */
public class Hex(public val hex: String) : Color