package hilo.utils.font;

import java.util.regex.Pattern;

public enum ChatColor {
    BLACK('0'),
    DARK_BLUE('1'),
    DARK_GREEN('2'),
    DARK_AQUA('3'),
    DARK_RED('4'),
    DARK_PURPLE('5'),
    GOLD('6'),
    GRAY('7'),
    DARK_GRAY('8'),
    BLUE('9'),
    GREEN('a'),
    AQUA('b'),
    RED('c'),
    LIGHT_PURPLE('d'),
    YELLOW('e'),
    WHITE('f'),
    MAGIC('k', true),
    BOLD('l', true),
    STRIKETHROUGH('m', true),
    UNDERLINE('n', true),
    ITALIC('o', true),
    RESET('r');

    // The typical color character, compiles into '§'
    public static final char COLOR_CHAR = '\u00A7';

    // Color character
    private final char code;

    // Formatted
    private final boolean isFormat;

    // Color char + color code turned into a string
    private final String toString;

    /**
     * Set the character
     *
     * @param code the color character
     */
    ChatColor(char code) {
        this(code, false);
    }

    /**
     * Set the character and if it should be formatted
     *
     * @param code     color character
     * @param isFormat a formatted string
     */
    ChatColor(char code, boolean isFormat) {
        this.code = code;
        this.isFormat = isFormat;
        toString = new String(new char[]{COLOR_CHAR, code});
    }

    /**
     * Strip all of the color from text
     *
     * @param input text that's being stripped
     * @return the string without any color formatting
     */
    public static String stripColor(final String input) {
        return input == null ? null : Pattern.compile("(?i)" + COLOR_CHAR + "[0-9A-FK-OR]").matcher(input).replaceAll("");
    }

}
