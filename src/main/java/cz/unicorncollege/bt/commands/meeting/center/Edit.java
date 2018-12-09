package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

public class Edit extends Command {

    @Override
    public void perform() {
        MeetingCentre performOnCenter = UserChoice.getChosenCenter();
        performOnCenter.setName(getOriginalIfEmpty(performOnCenter.getName(),Choices.getInput("Enter new name of MeetingCentre: ")));
        performOnCenter.setDescription( getOriginalIfEmpty(performOnCenter.getDescription(),Choices.getInput("Write new description for MeetingCentre: ")));
    }
}
