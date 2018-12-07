package cz.unicorncollege.bt.commands.main;

import cz.unicorncollege.bt.commands.*;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

import java.util.List;
import java.util.Map;

public class ListAllMeetingCentres extends Command {

    public ListAllMeetingCentres(MeetingController performOn) {
        super(performOn);
    }

    @Override
    public void perform(String[] params) {
        UserChoice userChoice = new UserChoice();
        Process process = new Process(true);
        Map<MeetingControllerCommandName, Command> commands = MeetingControllerCommandName.initCommands(performOn,process);
        List<String> choices = initChoices(commands.keySet());
        while (process.run())
            performCommands(userChoice, commands, choices);

    }

    private void performCommands(UserChoice userChoice, Map<MeetingControllerCommandName, Command> commands, List<String> choices) {
        try {
            commands.get(getCommand(userChoice, choices)).perform(userChoice.getCode());
        }catch (RuntimeException e){
            System.out.println("You have typed unknown command, use known command");
        }
    }

    private MeetingControllerCommandName getCommand(UserChoice userChoice, List<String> choices) {
        return MeetingControllerCommandName.getCommandByNumber(getInput(userChoice, choices));
    }


    private int getInput(UserChoice userChoice, List<String> choices) {
        printCenters();
        return userChoice.set(Choices.getInput("Choose option (including code after '-', example 1-M01): ",choices)).getOption();
    }

    private void printCenters(){
        System.out.println();
        performOn.getMeetingCentres().forEach(this::printCenter);
        System.out.println();
    }

    private void printCenter(MeetingCentre center){
        System.out.println("code: " + center.getCode() + ", name: " + center.getName());
		/*System.out.println("	-" + center.getDescription());
		System.out.println("contains rooms:");
		center.getMeetingRooms().forEach(meetingRoom -> {printRoom(meetingRoom);});*/
    }


}
