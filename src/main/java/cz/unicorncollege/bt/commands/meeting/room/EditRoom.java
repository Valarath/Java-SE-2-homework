package cz.unicorncollege.bt.commands.meeting.room;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.bt.utils.Choices;

public class EditRoom  extends Command {

    @Override
    public void perform() {
        showRoomBasicInfo();
        MeetingRoom chosenRoom = getMeetingRoomToEdit(Choices.getInput("Enter code of room you want to edit: "));
        while (chosenRoom==null)
            chosenRoom=getMeetingRoomToEdit(Choices.getInput("You must enter code of existing room: "));
        performUpdate(chosenRoom);
    }

    private void performUpdate(MeetingRoom chosenRoom) {
        chosenRoom.setName(getOriginalIfEmpty(chosenRoom.getName(), Choices.getInput("Enter new name: ")));
        chosenRoom.setDescription(getOriginalIfEmpty(chosenRoom.getName(),Choices.getInput("Enter new description: ")));
        chosenRoom.setVideoConference(getOriginalIfEmpty(chosenRoom.hasVideoConference(),Choices.getInput("Is video conference possible yes/no: ")));
        chosenRoom.setCapacity(getOriginalIfEmpty(chosenRoom.getCapacity(),Choices.getInput("Enter new capacity: ")));
    }

    private MeetingRoom getMeetingRoomToEdit(String roomCode){
        for(MeetingRoom room:UserChoice.getChosenCenter().getMeetingRooms())
            if (room.getCode().equals(roomCode))
                return room;
        return null;
    }

    private void showRoomBasicInfo(){
        System.out.println();
        UserChoice.getChosenCenter().getMeetingRooms().forEach(this::printRoom);
        System.out.println();
    }

    private void printRoom(MeetingRoom room){
        System.out.println("-- " + room.getCode()
                + ", "+ room.getName()
                + ", "+ room.getDescription()
                + ", capacity: "+ room.getCapacity()
                + ", is video conference possible: "+ room.hasVideoConference());
    }

    public static class NonExistingRoomException extends RuntimeException{}
}
