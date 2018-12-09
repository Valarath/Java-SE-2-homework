package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.controller.MeetingController;

public abstract class MeetingCenterCommand  extends Command {

    protected MeetingCenterCommand(MeetingController performOnController) {
        super(performOnController);
    }


}
