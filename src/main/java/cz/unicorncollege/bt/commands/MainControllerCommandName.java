package cz.unicorncollege.bt.commands;

import cz.unicorncollege.bt.commands.main.AddMeetingCenter;
import cz.unicorncollege.bt.commands.main.ImportData;
import cz.unicorncollege.bt.commands.main.KillProccessAndSave;
import cz.unicorncollege.bt.commands.main.ListAllMeetingCentres;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.controller.MeetingController;

import java.util.LinkedHashMap;
import java.util.Map;

public enum MainControllerCommandName implements CommandName {
    LIST_ALL_MEETING_CENTRES("List all Meeting Centres"),
    ADD_NEW_MEETING_CENTER("Add new Meeting Center"),
    IMPORT_DATA("Import data"),
    EXIT_AND_SAVE("Exit and save"),
    EXIT("Exit");
    private String description;

    MainControllerCommandName(String description) {
        this.description = description;
    }

    public static MainControllerCommandName getCommandByNumber(int commandNumber){
        return CommandName.getCommandByNumber(MainControllerCommandName.class,commandNumber);
    }

    public String getDescription() {
        return description;
    }


    public static Map<MainControllerCommandName, Command> initCommands(MeetingController controller, Process run){
        Map<MainControllerCommandName,Command> commands = new LinkedHashMap<>();
        commands.put(MainControllerCommandName.LIST_ALL_MEETING_CENTRES, new ListAllMeetingCentres(controller));
        commands.put(MainControllerCommandName.ADD_NEW_MEETING_CENTER, new AddMeetingCenter(controller));
        commands.put(MainControllerCommandName.IMPORT_DATA, new ImportData(controller));
        commands.put(MainControllerCommandName.EXIT_AND_SAVE, new KillProccessAndSave(controller,run));
        commands.put(MainControllerCommandName.EXIT, new KillProccess(run));
        return commands;
    }

}
