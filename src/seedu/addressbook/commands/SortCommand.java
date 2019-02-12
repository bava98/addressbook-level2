package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts all persons in the address book by their name and lists them to the user.
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Displays all persons in the address book as a list sorted by name with index numbers.\n"
        + "Example: " + COMMAND_WORD;
    
    @Override
    public CommandResult execute() {
        List <ReadOnlyPerson> sortedList = addressBook.sortListByName();
        return new CommandResult(getMessageForPersonListShownSummary(sortedList), sortedList);
    }
}
