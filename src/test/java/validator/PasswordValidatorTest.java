package validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PasswordValidatorTest {
    @DataProvider
    private static final Object[][] tooShortInput() {
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

    @Test(dataProvider = "tooShortInput")
    public void passwordShouldHasAtLeastNineCharacters(String input) {
        assertFalse(PasswordValidator.validate(input), "Password should has at least " + PasswordValidator.MINIMAL_LENGTH + " characters and has only: " + input.length());
    }

    @DataProvider
    private static final Object[][] properInput() {
        return new Object[][]{
                {"properLength"}
        };
    }

    @Test(dataProvider = "properInput")
    public void passwordWhichFulfilAllRequirementsShouldBeValid(String input) {
        assertTrue(PasswordValidator.validate(input), "Password fulfil all requirements should be valid");
    }
}
