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

    public abstract void perform();

    protected List<String> initChoices(Set<? extends CommandName> commandNames){
        return commandNames.stream()
                .map(CommandName::getDescription)
                .collect(Collectors.toList());
    }

    protected String returnWithData(String inputMessage){
        String input = Choices.getInput(inputMessage);
        while (input.length()==0)
            input = Choices.getInput("This parameter cannot be empty: ");
        return input;
    }

    protected String returnWithUniqueCode(String inputMessage, List<? extends MeetingObject> meetingObject){
        String newCode = returnWithData(inputMessage);
        while (codeExists(newCode,meetingObject))
            newCode=returnWithData("new code must be unique: ");
        return newCode;
    }

    protected boolean codeExists(String code,List<? extends MeetingObject> meetingObject){
        for(MeetingObject centre:meetingObject)
            if(centre.getCode().equals(code))
                return true;
        return false;
    }

    protected String getOriginalIfEmpty(String original, String newData){
        return newData.length()==0?original:newData;
    }

    protected int getOriginalIfEmpty(int original, String newData){
        while (newData.length()!=0 && !newData.matches("\\d+"))
            newData = Choices.getInput("This parameter has to contain number or be empty for skip: ");
        return newData.length()==0?original:Integer.parseInt(newData);
    }

    protected boolean getOriginalIfEmpty(Boolean original, String newData){
        while(!newData.equals("yes") && !newData.equals("no") && newData.length()!=0)
            newData=Choices.getInput("This input has to be yes or no, or empty for skip: ");
        return newData.length()==0?original: newData.equals("yes");
    }
}
