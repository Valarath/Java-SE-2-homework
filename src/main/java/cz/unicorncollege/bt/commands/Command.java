package cz.unicorncollege.bt.commands;

import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingObject;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Command {

    protected MeetingController performOn;


    protected Command(MeetingController performOn){
        this.performOn =performOn;
    }

    public abstract void perform(String... params);

    protected List<String> initChoices(Set<? extends CommandName> commandNames){
        return commandNames.stream()
                .map(CommandName::getDescription)
                .collect(Collectors.toList());
    }

    protected String returnWithData(String inputMessage){
        String input = Choices.getInput(inputMessage);
        while (input.length()==0)
            input = Choices.getInput("This parameter cannot be empty");
        return input;
    }

    protected String returnWithUniqueCode(String inputMessage, List<? extends MeetingObject> meetingObject){
        String newCode = returnWithData(inputMessage);
        while (codeExists(newCode,meetingObject))
            newCode=returnWithData("new code must be unique");
        return newCode;
    }

    private boolean codeExists(String code,List<? extends MeetingObject> meetingObject){
        for(MeetingObject centre:meetingObject)
            if(centre.getCode().equals(code))
                return false;
        return true;
    }

    protected String getOriginalIfEmpty(String original, String newData){
        return newData.length()==0?original:newData;
    }
}
