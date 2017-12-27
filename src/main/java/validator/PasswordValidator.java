package validator;

class PasswordValidator {

    static final int MINIMAL_LENGTH = 9;
    static final int MINIMAL_NB_OF_DIGITS = 2;

    static boolean validate(String input) {
        return input.length() >= MINIMAL_LENGTH && hasRequiredNumberOfDigits(input);
    }

    private static boolean hasRequiredNumberOfDigits(String input) {
        String regexForMinimalNbOfDigits = "(.*\\d){" + MINIMAL_NB_OF_DIGITS + "}.*";
        return input.matches(regexForMinimalNbOfDigits);
    }
}
