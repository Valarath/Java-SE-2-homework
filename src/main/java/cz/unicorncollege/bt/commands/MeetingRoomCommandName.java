package cz.unicorncollege.bt.commands;

import cz.unicorncollege.bt.commands.meeting.room.AddRoom;
import cz.unicorncollege.bt.commands.meeting.room.EditRoom;
import cz.unicorncollege.bt.commands.meeting.room.ShowRooms;
import cz.unicorncollege.bt.commands.support.Process;

import java.util.LinkedHashMap;
import java.util.Map;

public enum MeetingRoomCommandName implements CommandName {
    ADD("Add room"),
    EDIT("Edit room"),
    SHOW_ROOMS("Show rooms"),
    BACK("Go back");
    private String description;

    MeetingRoomCommandName(String description) {
        this.description = description;
    }


    public static MeetingRoomCommandName getCommandByNumber(int commandNumber){
        return CommandName.getCommandByNumber(MeetingRoomCommandName.class,commandNumber);
    }

    public static Map<MeetingRoomCommandName, Command> initCommands( Process process){
        Map<MeetingRoomCommandName, Command> commands = new LinkedHashMap<>();
        commands.put(MeetingRoomCommandName.SHOW_ROOMS,new ShowRooms());
        commands.put(MeetingRoomCommandName.ADD,new AddRoom());
        commands.put(MeetingRoomCommandName.EDIT,new EditRoom());
        commands.put(MeetingRoomCommandName.BACK,new KillProccess(process));
        return commands;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
