package com.work.translator.util;

/**
 *
 * @author linux
 */
public enum Languages {
    RUSSIAN("ru"),
    ENGLISH("en"),
    ARABIC("ar"),
    AZERBAIJANI("az"),
    CATALAN("ca"),
    CHINESE("zh"),
    CZECH("cs"),
    DANISH("da"),
    DUTCH("nl"),
    ESPERANTO("eo"),
    FINNISH("fi"),
    FRENCH("fr"),
    GERMAN("de"),
    GREEK("el"),
    HEBREW("he"),
    HINDI("hi"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KOREAN("ko"),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    SLOVAK("sk"),
    SPANISH("es"),
    SWEDISH("sv"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    NONE("none");

    private Languages(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    private final String code;
}
