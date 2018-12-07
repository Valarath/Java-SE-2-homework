package cz.unicorncollege.controller;

import java.util.*;

import cz.unicorncollege.bt.commands.*;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.utils.Choices;

/**
 * Main controller class.
 * Contains methods to communicate with user and methods to work with files.
 *
 * @author UCL
 */
public class MainController extends Controller{
	
    /**
	 * Main method, which runs the whole application.
	 *
	 * @param argv String[]
	 */
	public static void main(String[] argv) {
		MainController instance = new MainController();
		instance.run();
	}

	/**
	 * Method which shows the main menu and end after user chooses KillProccess.
	 */
	private void run() {
		Process program = new Process(true);
		Map<MainControllerCommandName, Command> commands = MainControllerCommandName.initCommands(initMeetingController(),program);
		List<String> choices = initChoices(commands.keySet());
		while (program.run())
			performCommands(commands, choices);
	}

	private void performCommands(Map<MainControllerCommandName, Command> commands, List<String> choices) {
		try {
			commands.get(getCommandByNumber(choices)).perform();
		}catch (MainControllerCommandName.UnknownCommandException e){
			System.out.println("You have typed unknown command, use known command");
		}
	}

	private MainControllerCommandName getCommandByNumber(List<String> choices) {
		return MainControllerCommandName.getCommandByNumber(Choices.getChoice("Select an option: ", choices));
	}

	private MeetingController initMeetingController(){
		MeetingController meetingController= new MeetingController();
		meetingController.init();
		return meetingController;
	}
}
