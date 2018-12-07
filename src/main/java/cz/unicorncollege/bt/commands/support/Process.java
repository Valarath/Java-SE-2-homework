package cz.unicorncollege.bt.commands.support;

public class Process {
    private boolean run;

    public Process(boolean run) {
        this.run = run;
    }

    public boolean run() {
        return run;
    }

    public void endProgram() {
        this.run = false;
    }
}
