package cz.unicorncollege.bt.commands.meeting.room;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.bt.utils.Choices;

public class AddRoom extends Command {


    @Override
    public void perform() {
        MeetingRoom newRoom = new MeetingRoom();
        newRoom.setCode(returnWithUniqueCode("Enter code of meeting room: ", UserChoice.getChosenCenter().getMeetingRooms()));
        newRoom.setName(returnWithData("Enter name of meeting room: "));
        newRoom.setDescription(returnWithData("Enter description of meeting room: "));
        newRoom.setCapacity(returnNumberWithData("Enter capacity of meeting room: "));
        newRoom.setVideoConference(returnBooleanWithData("Is possible video conference (yes/no): "));
        setRelationWithCenter(newRoom);
    }

    private boolean returnBooleanWithData(String inputMessage){
        String input = Choices.getInput(inputMessage);
        while (input.length()==0 || (!input.equals("yes") && !input.equals("no")))
            input = Choices.getInput("This parameter cannot be empty and value must be yes or no: ");
        return input.equals("yes");
    }

    private int returnNumberWithData(String inputMessage){
        String input = Choices.getInput(inputMessage);
        while (input.length()==0 || !input.matches("\\d+"))
            input = Choices.getInput("This parameter cannot be empty and has to contain number: ");
        return Integer.parseInt(input);
    }

    private void setRelationWithCenter( MeetingRoom newRoom) {
        newRoom.setMeetingCentre( UserChoice.getChosenCenter());
        UserChoice.getChosenCenter().getMeetingRooms().add(newRoom);
    }

}
