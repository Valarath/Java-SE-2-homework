package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

public class Delete extends Command {

    public Delete(MeetingController performOnController) {
        super(performOnController);
    }

    @Override
    public void perform() {
        MeetingCentre performOnCenter = UserChoice.getChosenCenter();
        if(checkIfNameMatch(performOnCenter, Choices.getInput("Enter name of MeetingCentre: ")))
            performDeleteOfCenter(performOnCenter);
        else
            System.out.println("name does not match");

    }

    private void performDeleteOfCenter(MeetingCentre centerToDelete) {
        performOn.getMeetingCentres().remove(centerToDelete);
        System.out.println("center was deleted");
    }

    private boolean checkIfNameMatch(MeetingCentre toCheck,String name){
        return toCheck.getName().equals(name);
    }

}
