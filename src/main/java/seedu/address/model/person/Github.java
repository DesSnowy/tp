package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's github account in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidGithubUsername(String)}
 */
public class Github {
    public static final String MESSAGE_CONSTRAINTS =
            "Github usernames should only contain - and alphanumeric characters";
    public static final String VALIDATION_REGEX = "^[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*$";
    public final String username;

    /**
     * Constructs an {@code Github}.
     *
     * @param githubUsername A valid GitHub username.
     */
    public Github(String githubUsername) {
        requireNonNull(githubUsername);
        checkArgument(isValidGithubUsername(githubUsername), MESSAGE_CONSTRAINTS);
        username = githubUsername;
    }

    /**
     * Returns if a given string is a valid username.
     */
    public static boolean isValidGithubUsername(String test) {
        return test.length() <= 39 && test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Github)) {
            return false;
        }

        Github otherGithub = (Github) other;
        return username.equals(otherGithub.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    /**
     * Compares the {@code username} of this Telegram object against another Telegram object.
     * Comparison is done using String::CompareTo method.
     */
    public int compareTo(Github otherGithub) {
        requireNonNull(otherGithub);
        return this.username.compareTo(otherGithub.username);
    }
}
