package cz.unicorncollege.bt.commands;

import cz.unicorncollege.bt.commands.meeting.center.MeetingCenterCommand;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.controller.MeetingController;

public class KillProccess extends MeetingCenterCommand {
    protected Process exit;

    protected KillProccess(Process exit, MeetingController controller) {
        super(controller);
        this.exit=exit;
    }

    public KillProccess(Process exit) {
        super(null);
        this.exit=exit;
    }

    @Override
    public void perform(String[] params) {
        exit.endProgram();
    }
}
