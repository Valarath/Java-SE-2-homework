package cz.unicorncollege.bt.model;

import java.util.ArrayList;
import java.util.List;

public class MeetingCentre extends MeetingObject {
	private List<MeetingRoom> meetingRooms = new ArrayList<>();

	public List<MeetingRoom> getMeetingRooms() {
		return meetingRooms;
	}

	public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}

	public StringBuilder toCsv(StringBuilder builder){
		return super.toCsv(builder);
	}

}
