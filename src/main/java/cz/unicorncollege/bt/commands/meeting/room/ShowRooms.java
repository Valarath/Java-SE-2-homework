package cz.unicorncollege.bt.commands.meeting.room;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.meeting.center.MeetingCenterCommand;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.controller.MeetingController;

import java.io.IOException;

public class ShowRooms extends MeetingRoomCommand {

    @Override
    public void perform(MeetingCentre meetingCentre) {
        System.out.println("This center contains these rooms:");
        System.out.println("-------------------------------------");
        meetingCentre.getMeetingRooms().forEach(this::printRoom);

    }

    private void printRoom(MeetingRoom room){
        System.out.println("-- " + room.getCode()
                + ", "+ room.getName()
                + ", "+ room.getDescription()
                + ", capacity: "+ room.getCapacity()
                + ", is video conference possible: "+ room.hasVideoConference());
    }

}
