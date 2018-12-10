package cz.unicorncollege.controller;

import java.util.*;

import cz.unicorncollege.bt.commands.*;
import cz.unicorncollege.bt.commands.support.GetCommand;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.utils.Choices;

/**
 * Main controller class.
 * Contains methods to communicate with user and methods to work with files.
 *
 * @author UCL
 */
public class MainController extends Controller {
	
    /**
	 * Main method, which runs the whole application.
	 *
	 * @param argv String[]
	 */
	public static void main(String[] argv) {
		MainController instance = new MainController();
		Process program = new Process(true);
		instance.run(MainControllerCommandName.initCommands(initMeetingController(),program),program,instance::getCommandByNumber);
	}

	private MainControllerCommandName getCommandByNumber(List<String> choices) {
		return MainControllerCommandName.getCommandByNumber(Choices.getChoice("Select an option: ", choices));
	}

	private static MeetingController initMeetingController(){
		MeetingController meetingController= new MeetingController();
		meetingController.init();
		return meetingController;
	}


}
