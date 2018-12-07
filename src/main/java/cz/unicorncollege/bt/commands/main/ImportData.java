package cz.unicorncollege.bt.commands.main;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.utils.FileParser;
import cz.unicorncollege.controller.MeetingController;

public class ImportData extends Command {

    public ImportData(MeetingController performOn) {
        super(performOn);
    }

    @Override
    public void perform(String[] params) {
        performOn.setMeetingCentres(FileParser.importData());
    }
}
