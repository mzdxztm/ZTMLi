package com.mzdxztm.ztm.library.string;

import java.util.regex.Pattern;

public class RegexUtils {

    /**
     * Return whether input matches the regex.
     * @param regex The regex.
     * @param input The input.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isMatch(final String regex, final CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

}
