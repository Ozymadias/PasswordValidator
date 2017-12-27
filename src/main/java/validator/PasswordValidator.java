package validator;

class PasswordValidator {

    static final int MINIMAL_LENGTH = 9;

    static boolean validate(String input) {
        return input.length() >= MINIMAL_LENGTH;
    }
}
