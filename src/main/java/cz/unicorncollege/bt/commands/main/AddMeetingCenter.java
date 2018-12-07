package cz.unicorncollege.bt.commands.main;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

public class AddMeetingCenter extends Command {

    public AddMeetingCenter(MeetingController performOn) {
        super(performOn);
    }

    @Override
    public void perform(String[] params) {
        MeetingCentre meetingCentre= new MeetingCentre();
        meetingCentre.setName(returnWithData(Choices.getInput("Enter name of meeting centre: ")));
        meetingCentre.setDescription( returnWithData(Choices.getInput("Write description for meeting centre: ")));
        meetingCentre.setCode( returnWithUniqueCode("Enter code of meeting centre: ",performOn.getMeetingCentres()));
        performOn.getMeetingCentres().add(meetingCentre);
    }

}
