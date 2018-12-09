package cz.unicorncollege.bt.commands;

import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.controller.MeetingController;

public class KillProccess extends Command {
    protected Process exit;

   protected KillProccess(Process exit, MeetingController controller) {
        super(controller);
        this.exit=exit;
    }

    public KillProccess(Process exit) {
        this.exit=exit;
    }

    @Override
    public void perform() {
        exit.endProgram();
    }
}
