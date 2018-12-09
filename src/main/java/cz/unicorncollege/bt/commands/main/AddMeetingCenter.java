package cz.unicorncollege.bt.commands.main;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

import java.util.ArrayList;

public class AddMeetingCenter extends Command {

    public AddMeetingCenter(MeetingController performOn) {
        super(performOn);
    }

    @Override
    public void perform() {
        MeetingCentre meetingCentre= new MeetingCentre();
        meetingCentre.setName(returnWithData("Enter name of meeting centre: "));
        meetingCentre.setDescription( returnWithData("Write description for meeting centre: "));
        meetingCentre.setCode( returnWithUniqueCode("Enter code of meeting centre: ",performOn.getMeetingCentres()));
        meetingCentre.setMeetingRooms(new ArrayList<>());
        performOn.getMeetingCentres().add(meetingCentre);
        System.out.println("New center was created. The name of the center is: " + meetingCentre.getName());
        System.out.println();
    }

}
