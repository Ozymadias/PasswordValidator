package validator;

class PasswordValidator {

    static final int MINIMAL_LENGTH = 9;
    static final int MINIMAL_NB_OF_DIGITS = 2;
    static final int MINIMAL_NB_OF_CAPITAL_LETTERS = 1;
    static final int MINIMAL_NB_OF_LOWER_LETTERS = 1;

    static boolean validate(String input) {
        return input.length() >= MINIMAL_LENGTH
                && hasRequiredNumberOfDigits(input)
                && hasRequiredNumberOfCapitalLetters(input)
                && hasRequiredNumberOfLowerLetters(input);
    }

    private static boolean hasRequiredNumberOfDigits(String input) {
        return input.matches(regex("\\d", MINIMAL_NB_OF_DIGITS));
    }

    private static boolean hasRequiredNumberOfCapitalLetters(String input) {
        return input.matches(regex("[A-Z]", MINIMAL_NB_OF_CAPITAL_LETTERS));
    }

    private static boolean hasRequiredNumberOfLowerLetters(String input) {
        return input.matches(regex("[a-z]", MINIMAL_NB_OF_LOWER_LETTERS));
    }

    private static String regex(String requirements, int minNb) {
        return "(.*" + requirements + "){" + minNb + "}.*";
    }
}
