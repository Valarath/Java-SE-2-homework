package cz.unicorncollege.bt.commands.meeting.room;

import cz.unicorncollege.bt.commands.meeting.room.MeetingRoomCommand;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

public class AddRoom extends MeetingRoomCommand {

    @Override
    public void perform(MeetingCentre meetingCentre) {
        MeetingRoom newRoom = new MeetingRoom();
        newRoom.setCode(returnWithUniqueCode("Enter code of meeting room: ",meetingCentre.getMeetingRooms()));
        newRoom.setName(returnWithData(Choices.getInput("Enter name of meeting room: ")));
        newRoom.setDescription(returnWithData(Choices.getInput("Enter description of meeting room: ")));
        newRoom.setCapacity(returnNumberWithData(Choices.getInput("Enter capacity of meeting room: ")));
        newRoom.setVideoConference(returnBooleanWithData(Choices.getInput("Is possible video conference (yes/no): ")));
        setRelationWithCenter(meetingCentre, newRoom);
    }

    private boolean returnBooleanWithData(String inputMessage){
        String input = Choices.getInput(inputMessage);
        while (input.length()==0 || !input.matches("yes") || !input.matches("no"))
            input = Choices.getInput("This parameter cannot be empty and value must be yes or no");
        return input.equals("true");
    }

    private int returnNumberWithData(String inputMessage){
        String input = Choices.getInput(inputMessage);
        while (input.length()==0 || !input.matches("\\d+"))
            input = Choices.getInput("This parameter cannot be empty and has to contain number");
        return Integer.parseInt(input);
    }

    private void setRelationWithCenter(MeetingCentre meetingCentre, MeetingRoom newRoom) {
        newRoom.setMeetingCentre(meetingCentre);
        meetingCentre.getMeetingRooms().add(newRoom);
    }

}
