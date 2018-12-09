package cz.unicorncollege.bt.commands;

import cz.unicorncollege.bt.commands.meeting.center.Delete;
import cz.unicorncollege.bt.commands.meeting.center.Edit;
import cz.unicorncollege.bt.commands.meeting.center.ShowDetails;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.controller.MeetingController;

import java.util.LinkedHashMap;
import java.util.Map;

public enum MeetingControllerCommandName implements CommandName{
    SHOW_DETAILS("Show Details of Meeting Centre with code:"),
    EDIT("Edit Meeting Centre with code:"),
    DELETE("Delete Meeting Centre with code:"),
    Back("Go Back to Home");

    private String description;

    public static MeetingControllerCommandName getCommandByNumber(int commandNumber){
        return CommandName.getCommandByNumber(MeetingControllerCommandName.class,commandNumber);
    }

    public static Map<MeetingControllerCommandName, Command> initCommands(MeetingController controller, Process run){
        Map<MeetingControllerCommandName, Command> commands = new LinkedHashMap<>();
        commands.put(MeetingControllerCommandName.SHOW_DETAILS, new ShowDetails(controller));
        commands.put(MeetingControllerCommandName.EDIT, new Edit());
        commands.put(MeetingControllerCommandName.DELETE, new Delete(controller));
        commands.put(MeetingControllerCommandName.Back, new KillProccess(run));
        return commands;
    }

    MeetingControllerCommandName(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
