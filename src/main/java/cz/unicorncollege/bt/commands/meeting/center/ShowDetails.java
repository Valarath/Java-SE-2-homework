package cz.unicorncollege.bt.commands.meeting.center;

import cz.unicorncollege.bt.commands.Command;
import cz.unicorncollege.bt.commands.MeetingControllerCommandName;
import cz.unicorncollege.bt.commands.MeetingRoomCommandName;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.commands.support.UserChoice;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.bt.utils.Choices;
import cz.unicorncollege.controller.MeetingController;

import java.util.List;
import java.util.Map;

public class ShowDetails extends Command {

   @Override
    public void perform() {
        Process process = new Process(true);
        Map<MeetingRoomCommandName, Command> roomCommands = MeetingRoomCommandName.initCommands(process);
        super.run(roomCommands,process,this::getCommand);

    }

    private MeetingRoomCommandName getCommand( List<String> choices) {
        System.out.println();
        showDetail();
        System.out.println();
        return MeetingRoomCommandName.getCommandByNumber(Choices.getChoice("Select an option: ", choices));
    }


    private void showDetail() {
        MeetingCentre chosenCenter = UserChoice.getChosenCenter();
        System.out.println("code: " + chosenCenter.getCode() + ", name: " + chosenCenter.getName() + ", description: " + chosenCenter.getDescription() + ", number of rooms: " + chosenCenter.getMeetingRooms().size());
    }


}
