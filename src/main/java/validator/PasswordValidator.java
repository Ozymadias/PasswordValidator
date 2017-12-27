package validator;

class PasswordValidator {

    static final int MINIMAL_LENGTH = 9;
    static final int MINIMAL_NB_OF_DIGITS = 2;
    static final int MINIMAL_NB_OF_CAPITAL_LETTERS = 1;

    static boolean validate(String input) {
        return input.length() >= MINIMAL_LENGTH && hasRequiredNumberOfDigits(input) && hasRequiredNumberOfCapitalLetters(input);
    }

    private static boolean hasRequiredNumberOfDigits(String input) {
        String regexForMinimalNbOfDigits = "(.*\\d){" + MINIMAL_NB_OF_DIGITS + "}.*";
        return input.matches(regexForMinimalNbOfDigits);
    }

    private static boolean hasRequiredNumberOfCapitalLetters(String input) {
        String regexForMinimalNbOfCapitalLetters = "(.*[A-Z]){" + MINIMAL_NB_OF_CAPITAL_LETTERS + "}.*";
        return input.matches(regexForMinimalNbOfCapitalLetters);
    }
}
