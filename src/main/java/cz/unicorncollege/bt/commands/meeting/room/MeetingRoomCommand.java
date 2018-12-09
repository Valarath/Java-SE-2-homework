package cz.unicorncollege.bt.commands.meeting.room;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.controller.MeetingController;

public abstract class MeetingRoomCommand extends Command {


    protected MeetingRoomCommand( ) {
        super(null);
    }
}
