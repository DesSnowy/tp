package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static seedu.address.testutil.Assert.assertThrows;

import java.awt.GraphicsEnvironment;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;

public class FunctionalBrowserTest {

    @Test
    public void getDesktop_sameFunctionalBrowserInstance_success() {
        assumeFalse(GraphicsEnvironment.isHeadless(), "Test not ran on headless environments");
        FunctionalBrowser browser1 = FunctionalBrowser.getDesktop();
        FunctionalBrowser browser2 = FunctionalBrowser.getDesktop();

        assertEquals(browser1, browser2);
    }

    @Test
    public void launchUri_nullUrl_throwsNullPointerException() {
        assumeFalse(GraphicsEnvironment.isHeadless(), "Test not ran on headless environments");
        FunctionalBrowser browser = FunctionalBrowser.getDesktop();
        assertThrows(NullPointerException.class, () -> browser.launchUri(null));
    }

    @Test
    public void launchUri_invalidUri_throwsUriSyntaxException() {
        assumeFalse(GraphicsEnvironment.isHeadless(), "Test not ran on headless environments");

        FunctionalBrowser browser = FunctionalBrowser.getDesktop();
        String expectedErrorMessage = "The URI specified is invalid.";

        //empty string
        assertThrows(CommandException.class, expectedErrorMessage, () -> browser.launchUri(" "));

        //invalid character "
        assertThrows(CommandException.class, expectedErrorMessage, () -> browser.launchUri("\""));

        //invalid character <
        assertThrows(CommandException.class, expectedErrorMessage, () -> browser.launchUri("<"));

        //invalid character >
        assertThrows(CommandException.class, expectedErrorMessage, () -> browser.launchUri(">"));

        //invalid character \
        assertThrows(CommandException.class, expectedErrorMessage, () -> browser.launchUri("\\"));
    }
}
