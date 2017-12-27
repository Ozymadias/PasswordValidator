package validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PasswordValidatorTest {
    @DataProvider
    private static final Object[][] tooShortInputs() {
        return new Object[][]{
                {"t"},
                {"to"},
                {"too"},
                {"tooS"},
                {"tooSh"},
                {"tooSho"},
                {"tooShor"},
                {"tooShort"},
        };
    }

    @Test(dataProvider = "tooShortInputs")
    public void passwordShouldHasAtLeastMinimalLength(String input) {
        assertFalse(PasswordValidator.validate(input), "Password should has at least " + PasswordValidator.MINIMAL_LENGTH + " characters and has only: " + input.length());
    }

    @DataProvider
    private static final Object[][] inputsWithoutEnoughDigits() {
        return new Object[][]{
                {"improperLength"},
                {"improperLength2"},
        };
    }

    @Test(dataProvider = "inputsWithoutEnoughDigits")
    public void passwordShouldHasAtLeastMinimalRequiredNumberOfDigits(String input) {
        assertFalse(PasswordValidator.validate(input), "Password should has at least " + PasswordValidator.MINIMAL_NB_OF_DIGITS + " digit(s)");
    }

    @DataProvider
    private static final Object[][] inputsWithoutRequiredNumberOfCapitalLetters() {
        return new Object[][]{
                {"improper01"}
        };
    }

    @Test(dataProvider = "inputsWithoutRequiredNumberOfCapitalLetters")
    public void passwordShouldHasAtLeastMinimalRequiredNumberOfCapitalLetters(String input) {
        assertFalse(PasswordValidator.validate(input), "Password should has at least " + PasswordValidator.MINIMAL_NB_OF_CAPITAL_LETTERS + " capital letter(s)");
    }

    @DataProvider
    private static final Object[][] properInput() {
        return new Object[][]{
                {"properPassword01"},
                {"AnotherProperPassword02"},
                {"ANOTHERProperPassword03"}
        };
    }

    @Test(dataProvider = "properInput")
    public void passwordWhichFulfilAllRequirementsShouldBeValid(String input) {
        assertTrue(PasswordValidator.validate(input), "Password fulfil all requirements should be valid");
    }
}
