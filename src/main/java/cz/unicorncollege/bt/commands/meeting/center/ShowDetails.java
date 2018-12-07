package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.MeetingControllerCommandName;
import cz.unicorncollege.bt.commands.MeetingRoomCommandName;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

import java.util.List;
import java.util.Map;

public class ShowDetails extends MeetingCenterCommand {

    public ShowDetails(MeetingController performOn) {
        super(performOn);
    }

    @Override
    public void perform(String[] code) {
        //performOn.showMeetingCentreDetails(findCentreByCode(code[0]));

        Process process = new Process(true);
        Map<MeetingRoomCommandName, Command> roomCommands = MeetingRoomCommandName.initCommands(process);
        List<String> choices = initChoices(roomCommands.keySet());
        while (process.run())
            roomCommands.get(MeetingRoomCommandName.getCommandByNumber(Choices.getChoice("choose operation number",choices))).perform();
    }


    private MeetingControllerCommandName getCommand(UserChoice userChoice, List<String> choices) {
        return MeetingControllerCommandName.getCommandByNumber(getInput(userChoice, choices));
    }


    private int getInput(UserChoice userChoice, List<String> choices) {
        printCenters();
        return userChoice.set(Choices.getInput("Choose option (including code after '-', example 1-M01): ",choices)).getOption();
    }
}
