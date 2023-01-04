package common;

public class Regex {
    public static boolean checkName(String name) {
        final String NAME_REGEX = "[A-Z][\\D]+";
        return name.matches(NAME_REGEX);
    }
}
