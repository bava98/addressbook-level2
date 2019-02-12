package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Displays all persons in the address book as a list sorted by name with index numbers.\n"
        + "Example: " + COMMAND_WORD;
    
    class SortByName implements Comparator<ReadOnlyPerson> {
        public int compare (ReadOnlyPerson person1, ReadOnlyPerson person2) {
            return person1.getName().toString().compareTo(person2.getName().toString());
        }
    }
    
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        Collections.sort(allPersons, new SortByName());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
