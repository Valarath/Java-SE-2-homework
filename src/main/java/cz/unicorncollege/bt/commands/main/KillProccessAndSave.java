package cz.unicorncollege.bt.commands.main;

import cz.unicorncollege.bt.commands.KillProccess;
import cz.unicorncollege.bt.commands.support.Process;
import cz.unicorncollege.bt.model.MeetingCentre;
import cz.unicorncollege.bt.model.MeetingRoom;
import cz.unicorncollege.bt.utils.FileParser;
import cz.unicorncollege.controller.MeetingController;

import java.util.ArrayList;
import java.util.List;

public class KillProccessAndSave extends KillProccess {

    public KillProccessAndSave(MeetingController performOn, Process exit) {
        super(exit,performOn);
    }

    @Override
    public void perform() {
        FileParser.saveData("data.csv",toSaveString());
        super.perform();
    }

    public String toSaveString() {
        StringBuilder builder = new StringBuilder("MEETING_CENTRES");
        List<MeetingRoom> rooms = new ArrayList<>();
        convertMeetingCentresToCsv( builder, rooms);
        convertRoomsToCsv(builder, rooms);
        return builder.toString();
    }


    private  void convertMeetingCentresToCsv(StringBuilder builder, List<MeetingRoom> rooms) {
        for(MeetingCentre centre: performOn.getMeetingCentres()){
            rooms.addAll(centre.getMeetingRooms());
            centre.toCsv(builder);
        }
        builder.append(System.getProperty("line.separator"));
    }

    private void convertRoomsToCsv(StringBuilder builder, List<MeetingRoom> rooms) {
        builder.append("MEETING_ROOMS");
        for(MeetingRoom room: rooms)
            room.toCsv(builder);
    }
}
