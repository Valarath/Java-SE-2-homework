package cz.unicorncollege.bt.commands.meeting.room;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingRoom;

public class ShowRooms extends Command {

    @Override
    public void perform() {
        System.out.println("This center contains these rooms:");
        System.out.println("-------------------------------------");
        UserChoice.getChosenCenter().getMeetingRooms().forEach(this::printRoom);

    }

    private void printRoom(MeetingRoom room){
        System.out.println("-- " + room.getCode()
                + ", "+ room.getName()
                + ", "+ room.getDescription()
                + ", capacity: "+ room.getCapacity()
                + ", is video conference possible: "+ room.hasVideoConference());
    }

}
