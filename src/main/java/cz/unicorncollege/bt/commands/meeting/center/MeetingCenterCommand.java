package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.controller.MeetingController;

public abstract class MeetingCenterCommand  extends Command {

    protected MeetingCenterCommand(MeetingController performOn) {
        super(performOn);
    }

    protected MeetingCentre findCentreByCode(String code){
        for(MeetingCentre meetingCentre:performOn.getMeetingCentres())
            if(meetingCentre.getCode().equals(code))
                return meetingCentre;
        throw new WrongMeetingCenterCodeException();
    }

    public static class WrongMeetingCenterCodeException extends RuntimeException{}
}
