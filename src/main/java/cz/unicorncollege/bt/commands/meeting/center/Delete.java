package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

public class Delete extends MeetingCenterCommand {

    public Delete(MeetingController performOn) {
        super(performOn);
    }

    @Override
    public void perform(String[] code) {
        MeetingCentre centerToDelete = findCentreByCode(code[0]);
        if(checkIfNameMatch(centerToDelete, Choices.getInput("Enter name of MeetingCentre: ")))
            performDeleteOfCenter(centerToDelete);
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
