package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

public class Edit extends MeetingCenterCommand {


    public Edit(MeetingController performOn) {
        super(performOn);
    }


    @Override
    public void perform(String[] code) {
        MeetingCentre centerToEdit = findCentreByCode(code[0]);
        centerToEdit.setName(getOriginalIfEmpty(centerToEdit.getName(),Choices.getInput("Enter new name of MeetingCentre: ")));
        centerToEdit.setDescription( getOriginalIfEmpty(centerToEdit.getDescription(),Choices.getInput("Write new description for MeetingCentre: ")));
    }
}
